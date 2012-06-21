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

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class GermplasmGenerationHistoryComponent extends VerticalLayout{

    private Table tableGermplasmHistory;

    public GermplasmGenerationHistoryComponent(GermplasmIndexContainer DataIndexContainer, GermplasmDetailModel gDetailModel) {

        IndexedContainer dataSourceGenerationHistory = DataIndexContainer.getGermplasGenerationHistory(gDetailModel);
        tableGermplasmHistory = new Table("", dataSourceGenerationHistory);
        tableGermplasmHistory.setSelectable(true);
        tableGermplasmHistory.setMultiSelect(false);
        tableGermplasmHistory.setImmediate(true); // react at once when
                                                  // something is selected

        // turn on column reordering and collapsing
        tableGermplasmHistory.setColumnReorderingAllowed(true);
        tableGermplasmHistory.setColumnCollapsingAllowed(true);
        tableGermplasmHistory.setSizeFull();

        // set column headers
        tableGermplasmHistory.setColumnHeaders(new String[] { "GID", "PREFNAME" });
        addComponent(tableGermplasmHistory);
        setSpacing(true);
        setMargin(true);
    }

}