/*******************************************************************************
 * Copyright (c) 2012, All Rights Reserved.
 * 
 * Generation Challenge Programme (GCP)
 * 
 * 
 * This software is licensed for use under the terms of the GNU General Public
 * License (http://bit.ly/8Ztv8M) and the provisions of Part F of the Generation
 * Challenge Programme Amended Consortium Agreement (http://bit.ly/KQX1nL)
 * 
 *******************************************************************************/

package org.generationcp.browser.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.generationcp.middleware.exceptions.QueryException;
import org.generationcp.middleware.manager.api.StudyDataManager;
import org.generationcp.middleware.pojos.CharacterDataElement;
import org.generationcp.middleware.pojos.CharacterLevelElement;
import org.generationcp.middleware.pojos.NumericDataElement;
import org.generationcp.middleware.pojos.NumericLevelElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.addons.lazyquerycontainer.Query;

import com.vaadin.data.Item;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;

/**
 * An implementation of Query which is needed for using the LazyQueryContainer.
 * 
 * Reference:
 * https://vaadin.com/wiki/-/wiki/Main/Lazy%20Query%20Container/#section
 * -Lazy+Query+Container-HowToImplementCustomQueryAndQueryFactory
 * 
 * @author Kevin Manansala
 * 
 */
public class RepresentationDataSetQuery implements Query{

    private final static Logger LOG = LoggerFactory.getLogger(RepresentationDataSetQuery.class);

    private StudyDataManager dataManager;
    private Integer representationId;
    private List<String> columnIds;

    /**
     * These parameters are passed by the QueryFactory which instantiates
     * objects of this class.
     * 
     * @param dataManager
     * @param representationId
     * @param columnIds
     */
    public RepresentationDataSetQuery(StudyDataManager dataManager, Integer representationId, List<String> columnIds) {
        super();
        this.dataManager = dataManager;
        this.representationId = representationId;
        this.columnIds = columnIds;
    }

    /**
     * This method seems to be called for creating blank items on the Table
     */
    @Override
    public Item constructItem() {
        PropertysetItem item = new PropertysetItem();
        for (String id : columnIds) {
            item.addItemProperty(id, new ObjectProperty<String>(""));
        }
        return item;
    }

    @Override
    public boolean deleteAllItems() {
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieves the dataset by batches of rows. Used for lazy loading the
     * dataset.
     */
    @Override
    public List<Item> loadItems(int start, int numOfRows) {
        List<Item> items = new ArrayList<Item>();
        Map<Integer, Item> itemMap = new HashMap<Integer, Item>();
        List<Integer> ounitids = new ArrayList<Integer>();

        try {

            ounitids = dataManager.getOunitIDsByRepresentationId(representationId, start, numOfRows);
        } catch (QueryException ex) {
            // Log error in log file
            LOG.error("Error with getting ounitids for representation: " + representationId + "\n" + ex.toString());
            // System.out.println("Error with getting ounitids for representation: "
            // + representationId);
            // System.out.println(ex);
            // ex.printStackTrace();
            ounitids = new ArrayList<Integer>();
        }

        if (!ounitids.isEmpty()) {
            // get character levels
            List<CharacterLevelElement> charLevels = new ArrayList<CharacterLevelElement>();

            try {
                charLevels = dataManager.getCharacterLevelValuesByOunitIdList(ounitids);
            } catch (QueryException ex) {
                // Log error in log file
                LOG.error("Error with getting character level values" + "\n" + ex.toString());
                // System.out.println("Error with getting character level values");
                // System.out.println(ex);
                // ex.printStackTrace();
                charLevels = new ArrayList<CharacterLevelElement>();
            }

            for (CharacterLevelElement charLevel : charLevels) {
                String columnId = charLevel.getFactorId() + "-" + charLevel.getFactorName();
                // get Item for ounitid
                Item item = itemMap.get(charLevel.getOunitId());
                if (item == null) {
                    // not yet in map so create a new Item and add to map
                    item = new PropertysetItem();
                    itemMap.put(charLevel.getOunitId(), item);
                }

                item.addItemProperty(columnId, new ObjectProperty<String>(charLevel.getValue()));
            }

            // get numeric levels
            List<NumericLevelElement> numericLevels = new ArrayList<NumericLevelElement>();

            try {
                numericLevels = dataManager.getNumericLevelValuesByOunitIdList(ounitids);
            } catch (QueryException ex) {
                // Log error in log file
                LOG.error("Error with getting numeric level values" + "\n" + ex.toString());
                // System.out.println("Error with getting numeric level values");
                // System.out.println(ex);
                // ex.printStackTrace();
                numericLevels = new ArrayList<NumericLevelElement>();
            }

            for (NumericLevelElement numericLevel : numericLevels) {
                String columnId = numericLevel.getFactorId() + "-" + numericLevel.getFactorName();
                // get Item for ounitid
                Item item = itemMap.get(numericLevel.getOunitId());
                if (item == null) {
                    // not yet in map so create a new Item and add to map
                    item = new PropertysetItem();
                    itemMap.put(numericLevel.getOunitId(), item);
                }

                item.addItemProperty(columnId, new ObjectProperty<String>(numericLevel.getValue().toString()));
            }

            // get character data
            List<CharacterDataElement> characterDatas = new ArrayList<CharacterDataElement>();

            try {
                characterDatas = dataManager.getCharacterDataValuesByOunitIdList(ounitids);
            } catch (QueryException ex) {
                // Log error in log file
                LOG.error("Error with getting character data values" + "\n" + ex.toString());
                // System.out.println("Error with getting character data values");
                // System.out.println(ex);
                // ex.printStackTrace();
                characterDatas = new ArrayList<CharacterDataElement>();
            }

            for (CharacterDataElement characterData : characterDatas) {
                String columnId = characterData.getVariateId().toString();
                // get Item for ounitid
                Item item = itemMap.get(characterData.getOunitId());
                if (item == null) {
                    // not yet in map so create a new Item and add to map
                    item = new PropertysetItem();
                    itemMap.put(characterData.getOunitId(), item);
                }

                item.addItemProperty(columnId, new ObjectProperty<String>(characterData.getValue()));
            }

            // get numeric data
            List<NumericDataElement> numericDatas = new ArrayList<NumericDataElement>();

            try {
                numericDatas = dataManager.getNumericDataValuesByOunitIdList(ounitids);
            } catch (QueryException ex) {
                // Log error in log file
                LOG.error("Error with getting character data values" + "\n" + ex.toString());
                // System.out.println("Error with getting character data values");
                // System.out.println(ex);
                // ex.printStackTrace();
                numericDatas = new ArrayList<NumericDataElement>();
            }

            for (NumericDataElement numericData : numericDatas) {
                String columnId = numericData.getVariateId().toString();
                // get Item for ounitid
                Item item = itemMap.get(numericData.getOunitId());
                if (item == null) {
                    // not yet in map so create a new Item and add to map
                    item = new PropertysetItem();
                    itemMap.put(numericData.getOunitId(), item);
                }

                item.addItemProperty(columnId, new ObjectProperty<String>(numericData.getValue().toString()));
            }
        }

        items.addAll(itemMap.values());
        return items;
    }

    @Override
    public void saveItems(List<Item> arg0, List<Item> arg1, List<Item> arg2) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the total number of rows to be displayed on the Table
     */
    @Override
    public int size() {
        try {
            int size = dataManager.countOunitIDsByRepresentationId(representationId).intValue();
            return size;
        } catch (QueryException ex) {
            // Log error in log file
            LOG.error("Error with getting number of ounitids for representation: " + representationId + "\n" + ex.toString());
            // System.out.println("Error with getting number of ounitids for representation: "
            // + representationId);
            // System.out.println(ex);
            // ex.printStackTrace();
            return 0;
        }
    }

}