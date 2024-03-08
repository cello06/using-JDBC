package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.StaffMapper;
import com.inar.reqres.user.management.model.Staff;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class StaffService {

    public List<Staff> getListOfAllStaffs(){
        String query = "SELECT * FROM staff;";
        return DBUtils.executeQuery(query,new StaffMapper());
    }

    public Staff getAStaffByStaffId(int staffId){
        String query = "SELECT * FROM staff WHERE staff_id = " + staffId;
        List<Staff> staffList = DBUtils.executeQuery(query,new StaffMapper());

        return staffList.isEmpty() ? null : staffList.get(0);
    }
}
