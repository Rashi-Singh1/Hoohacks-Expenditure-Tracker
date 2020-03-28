package com.example.expendituretracker;

public interface Common {
    interface OTPListener {
        void onOTPReceived(String name,String amount);
    }
}