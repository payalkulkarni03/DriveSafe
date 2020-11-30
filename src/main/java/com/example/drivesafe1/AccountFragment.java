package com.example.drivesafe1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class AccountFragment extends Fragment {


    public ImageView ownerImage;
    public TextView mainOwnerName,vehicle_name;
    public ListView usersList;
    public Spinner vehicleList;

    private FirebaseAuth firebaseAuth;



    public AccountFragment()
    {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_account,container,false);

        firebaseAuth = FirebaseAuth.getInstance();

        ownerImage = (ImageView) view.findViewById(R.id.ownerImage);
        mainOwnerName = view.findViewById(R.id.tv_mainOwnerName);
        usersList = view.findViewById(R.id.users_list);
        usersList.setClickable(true);

        vehicleList = view.findViewById(R.id.vehicle_select);

        mainOwnerName.setText(firebaseAuth.getCurrentUser().getUid());



        ArrayList<String> vehicleArray = new ArrayList<>();
        vehicleArray.add("MH12AB1234");
        vehicleArray.add("MH12AB2345");
        vehicleArray.add("MH12AB3456");
        vehicleArray.add("MH12AB4567");
        vehicleArray.add("MH12AB5678");

        @SuppressLint("ResourceType") ArrayAdapter<String> vehicleAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,vehicleArray);
        vehicleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleList.setAdapter(vehicleAdapter);


        //ownerImage.setImageResource(R.drawable.ic_launcher_background);
        return view;

    }




}
