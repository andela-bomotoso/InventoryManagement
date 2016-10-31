package com.example.bukola_omotoso.inventorymanagement;


public interface Login {

    public void onLogin(String  userName, String password, LoginCallBack callBack);

    interface LoginCallBack{
        public void callBack(boolean success);
    }
}
