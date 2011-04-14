package aptech.view.semester;


import aptech.view.semester.inputClassOffer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anhson
 */
public class EditClassOffer extends inputClassOffer{
    public EditClassOffer() throws java.lang.Exception{
        initComponentV2();
    }
    protected void initClassOfferToEdit() {
        getBtnDelete().setVisible(true);
    }
}
