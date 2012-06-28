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

package org.generationcp.browser.germplasm;

import org.generationcp.browser.germplasm.listeners.GermplasmSelectedTabChangeListener;
import org.generationcp.browser.i18n.ui.I18NAccordion;
import org.generationcp.browser.i18n.ui.I18NVerticalLayout;
import org.generationcp.middleware.exceptions.QueryException;

import com.github.peholmst.i18n4vaadin.I18N;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;

public class GermplasmDetail extends I18NAccordion {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GermplasmIndexContainer DataIndexContainer;
    private GermplasmQueries qQuery;
    private GermplasmDetailModel gDetailModel;
    private I18NVerticalLayout layoutNames;
    private I18NVerticalLayout layoutAttributes;
    private I18NVerticalLayout layoutGenerationHistory;
    private I18NVerticalLayout layoutPedigreeTree;
    private I18NVerticalLayout mainLayout;
    private int gid;
    private TabSheet tabSheet;
    private GermplasmIndexContainer dataResultIndexContainer;

    public GermplasmDetail(int gid, GermplasmQueries qQuery, GermplasmIndexContainer dataResultIndexContainer, I18NVerticalLayout mainLayout,
            TabSheet tabSheet, I18N i18n) throws QueryException {

    	super(i18n);
    	
        this.qQuery = qQuery;
        this.mainLayout = mainLayout;
        this.gid = gid;
        this.tabSheet = tabSheet;
        this.dataResultIndexContainer = dataResultIndexContainer;
        this.DataIndexContainer = dataResultIndexContainer;
        this.DataIndexContainer = dataResultIndexContainer;
        gDetailModel = this.qQuery.getGermplasmDetails(gid);

        layoutNames = new I18NVerticalLayout(this.getI18N());
        layoutAttributes = new I18NVerticalLayout(this.getI18N());
        layoutGenerationHistory = new I18NVerticalLayout(this.getI18N());
        layoutPedigreeTree = new I18NVerticalLayout(this.getI18N());

        this.addTab(new GermplasmCharacteristicsComponent(gDetailModel, this.getI18N()), "Characteristics");
        this.addTab(layoutNames, "Names");
        this.addTab(layoutAttributes, "Attributes");
        this.addTab(layoutGenerationHistory, "Generation History");
        this.addTab(layoutPedigreeTree, "Pedigree Tree");
        this.addListener(new GermplasmSelectedTabChangeListener(this, i18n));
        setSizeFull();

    }

    public void selectedTabChangeAction() throws QueryException {
        Component selected = this.getSelectedTab();
        Tab tab = this.getTab(selected);
        if (tab.getCaption().equals("Names")) {
            if (layoutNames.getComponentCount() == 0) {
                layoutNames.addComponent(new GermplasmNamesComponent(DataIndexContainer, gDetailModel, this.getI18N()));
            }
        } else if (tab.getCaption().equals("Attributes")) {
            if (layoutAttributes.getComponentCount() == 0) {
                layoutAttributes.addComponent(new GermplasmAttributesComponent(DataIndexContainer, gDetailModel, this.getI18N()));
            }
        } else if (tab.getCaption().equals("Generation History")) {
            if (layoutGenerationHistory.getComponentCount() == 0) {
                layoutGenerationHistory.addComponent(new GermplasmGenerationHistoryComponent(DataIndexContainer, gDetailModel, this.getI18N()));
            }
        } else if (tab.getCaption().equals("Pedigree Tree")) {
            if (layoutPedigreeTree.getComponentCount() == 0) {
                layoutPedigreeTree.addComponent(new GermplasmPedigreeTreeComponent(gid, qQuery, dataResultIndexContainer, mainLayout,
                        tabSheet, this.getI18N()));
            }
        }

    }

}