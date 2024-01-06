package com.example.userManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HajjUser{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hajj_seq")
    @SequenceGenerator(sequenceName = "hajj_seq", allocationSize = 1, name = "hajj_seq")
    private Long id;
    String external_ref_no;
    String reg_by;
    String payment_code;
    String first_name;
    String last_name;
    String middle_name;
    String phone;
    String passport_number;
    String birth_date;
    String service_package;
    boolean paid;
    double amount;
    String trn_code;
    String ac_branch;
    String branch_name;
    String narration;
    String cust_name;
    String trn_ref_no;
    String ac_no;
    String lcy_amount;
    String related_customer;
    String related_account;
    String trn_dt;
    String value_dt;
    String userid;
    String avldays;
    String auth_id;
    String stmt_dt;
    String node;
    String ac_ccy;
    String auth_timestamp;

    public HajjUser(){

    }

    public HajjUser(String external_ref_no, String reg_by, String payment_code, String first_name, String last_name, String middle_name, String phone, String passport_number, String birth_date, String service_package, boolean paid, double amount, String trn_code, String ac_branch, String branch_name, String narration, String cust_name, String trn_ref_no, String ac_no, String lcy_amount, String related_customer, String related_account, String trn_dt, String value_dt, String userid, String avldays, String auth_id, String stmt_dt, String node, String ac_ccy, String auth_timestamp) {
        this.external_ref_no = external_ref_no;
        this.reg_by = reg_by;
        this.payment_code = payment_code;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.phone = phone;
        this.passport_number = passport_number;
        this.birth_date = birth_date;
        this.service_package = service_package;
        this.paid = paid;
        this.amount = amount;
        this.trn_code = trn_code;
        this.ac_branch = ac_branch;
        this.branch_name = branch_name;
        this.narration = narration;
        this.cust_name = cust_name;
        this.trn_ref_no = trn_ref_no;
        this.ac_no = ac_no;
        this.lcy_amount = lcy_amount;
        this.related_customer = related_customer;
        this.related_account = related_account;
        this.trn_dt = trn_dt;
        this.value_dt = value_dt;
        this.userid = userid;
        this.avldays = avldays;
        this.auth_id = auth_id;
        this.stmt_dt = stmt_dt;
        this.node = node;
        this.ac_ccy = ac_ccy;
        this.auth_timestamp = auth_timestamp;
    }
}
