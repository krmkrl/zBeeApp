package com.aga.learning.zbeeapp;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.swedspot.automotive.AutomotiveManager;
import android.swedspot.automotiveapi.AutomotiveSignal;
import android.swedspot.automotiveapi.AutomotiveSignalId;
import android.swedspot.scs.data.SCSFloat;
import android.util.Log;

import com.swedspot.automotiveapi.AutomotiveListener;

public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutomotiveManager manager = (AutomotiveManager) getApplicationContext().getSystemService(Context.AUTOMOTIVE_SERVICE);

        manager.setListener(new AutomotiveListener() {
            @Override
            public void timeout(final int signalId) {
                // Request did time out and no data was received
                Log.d(TAG, "timeout " + signalId);
            }

            @Override
            public void receive(final AutomotiveSignal automotiveSignal) {
                // Incoming signal
                switch (automotiveSignal.getSignalId()) {
                    case AutomotiveSignalId.FMS_WHEEL_BASED_SPEED:
                        // Unsafe type cast. Could be made safe with automotiveSignal.getData().getDataType()
                        Log.d(TAG, "FMS_WHEEL_BASED_SPEED: " + ((SCSFloat) automotiveSignal.getData()).getFloatValue() + " " + automotiveSignal.getUnit().toString());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void notAllowed(final int signalId) {
                // Policy does not allow for this operation
                Log.d(TAG, "not allowed " + signalId);
            }
        });

        //register for signal updates
        manager.register(AutomotiveSignalId.FMS_WHEEL_BASED_SPEED);

        //request value directly
        manager.requestValue(AutomotiveSignalId.FMS_WHEEL_BASED_SPEED);
    }
}
