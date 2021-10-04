/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.query;

public class ItemQuery {
    public static final String LOAD_ALL_ITEM_DATA = "SELECT * FROM item";
    public static final String LOAD_SPECIFIC_ITEM_DATA = "SELECT * FROM item WHERE itemCode = ?";
    public static final String UPDATE_ORDER_QUANTITY_DATA = "UPDATE item SET quantity = ? WHERE itemCode = ?";
}
