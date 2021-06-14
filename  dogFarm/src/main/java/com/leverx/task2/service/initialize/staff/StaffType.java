package com.leverx.task2.service.initialize.staff;

import com.leverx.task2.entity.Caretakers;
import com.leverx.task2.entity.Staff;
import com.leverx.task2.entity.Trainer;
import com.leverx.task2.entity.Vet;

public enum StaffType {
    CARETAKERS(new Caretakers()),
    TRAINER(new Trainer()),
    VET(new Vet());

    private Staff staff;

    StaffType(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }
}
