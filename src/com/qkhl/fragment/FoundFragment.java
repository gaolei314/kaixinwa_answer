package com.qkhl.fragment;



import com.qkhl.kaixinwa_android.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FoundFragment extends Fragment{
	
	
	private TextView tv1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View firstpagelayout = inflater.inflate(R.layout.faxian_fragment, container, false);
		return firstpagelayout;
	}
	
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
//		tv1=(TextView) getActivity().findViewById(R.id.tv1);
	}

}
