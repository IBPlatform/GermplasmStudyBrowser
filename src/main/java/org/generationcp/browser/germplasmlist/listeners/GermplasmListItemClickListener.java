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

package org.generationcp.browser.germplasmlist.listeners;

import org.generationcp.browser.germplasm.GermplasmListComponent;
import org.generationcp.browser.germplasm.containers.ListsForGermplasmQuery;
import org.generationcp.browser.germplasmlist.GermplasmListTreeComponent;
import org.generationcp.commons.exceptions.InternationalizableException;
import org.generationcp.commons.vaadin.util.MessageNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.MouseEvents.ClickEvent;

public class GermplasmListItemClickListener implements ItemClickEvent.ItemClickListener{

    private static final Logger LOG = LoggerFactory.getLogger(GermplasmListItemClickListener.class);
    private static final long serialVersionUID = -4521207966700882960L;

    private Object source;

    public GermplasmListItemClickListener(Object source) {
        this.source = source;
    }

    @Override
    public void itemClick(ItemClickEvent event) {

        if (source instanceof GermplasmListTreeComponent) {
            int germplasmListId = Integer.valueOf(event.getItemId().toString());
            if (event.getButton() == ClickEvent.BUTTON_LEFT) {
                try {
                    ((GermplasmListTreeComponent) source).germplasmListTreeItemClickAction(germplasmListId);
                } catch (InternationalizableException e) {
                    LOG.error(e.toString() + "\n" + e.getStackTrace());
                    e.printStackTrace();
                    MessageNotifier.showError(event.getComponent().getWindow(), e.getCaption(), e.getDescription());
                }
            }
        }
        
        if (source instanceof GermplasmListComponent) {
        	int listId = Integer.valueOf(event.getItem().getItemProperty(ListsForGermplasmQuery.GERMPLASMLIST_ID).getValue().toString());
        	if (event.getButton() == ClickEvent.BUTTON_LEFT) {
                try {
                    ((GermplasmListComponent) source).listItemClickAction(event, listId);
                } catch (InternationalizableException e) {
                    LOG.error(e.toString() + "\n" + e.getStackTrace());
                    e.printStackTrace();
                    MessageNotifier.showError(event.getComponent().getWindow(), e.getCaption(), e.getDescription());  
                }
            }
        }
    }

}
