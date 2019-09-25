/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class Company {

    @Property()
    private String companyId;
    private String documentKey;
    private String documentValue;
    private String name;
    private String phone;
    private String email;
    private Process[] processes;
    private Record[] records;
    private PersonInCharge[] personsInCharge;
    private StorageDeviceType[] storageDeviceTypes;

    public Company() {
    }

    public Company(String companyId, String documentKey, String documentValue, String name, String phone, String email,
            Process[] processes, Record[] records, PersonInCharge[] personsInCharge,
            StorageDeviceType[] storageDeviceTypes) {
        this.companyId = companyId;
        this.documentKey = documentKey;
        this.documentValue = documentValue;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.processes = processes;
        this.records = records;
        this.personsInCharge = personsInCharge;
        this.storageDeviceTypes = storageDeviceTypes;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDocumentKey() {
        return this.documentKey;
    }

    public void setDocumentKey(String documentKey) {
        this.documentKey = documentKey;
    }

    public String getDocumentValue() {
        return this.documentValue;
    }

    public void setDocumentValue(String documentValue) {
        this.documentValue = documentValue;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Process[] getProcesses() {
        return this.processes;
    }

    public void setProcesses(Process[] processes) {
        this.processes = processes;
    }

    public Record[] getRecords() {
        return this.records;
    }

    public void setRecords(Record[] records) {
        this.records = records;
    }

    public PersonInCharge[] getPersonsInCharge() {
        return this.personsInCharge;
    }

    public void setPersonsInCharge(PersonInCharge[] personsInCharge) {
        this.personsInCharge = personsInCharge;
    }

    public StorageDeviceType[] getStorageDeviceTypes() {
        return this.storageDeviceTypes;
    }

    public void setStorageDeviceTypes(StorageDeviceType[] storageDeviceTypes) {
        this.storageDeviceTypes = storageDeviceTypes;
    }

    public Company companyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public Company documentKey(String documentKey) {
        this.documentKey = documentKey;
        return this;
    }

    public Company documentValue(String documentValue) {
        this.documentValue = documentValue;
        return this;
    }

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public Company phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Company email(String email) {
        this.email = email;
        return this;
    }

    public Company processes(Process[] processes) {
        this.processes = processes;
        return this;
    }

    public Company records(Record[] records) {
        this.records = records;
        return this;
    }

    public Company personsInCharge(PersonInCharge[] personsInCharge) {
        this.personsInCharge = personsInCharge;
        return this;
    }

    public Company storageDeviceTypes(StorageDeviceType[] storageDeviceTypes) {
        this.storageDeviceTypes = storageDeviceTypes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Company)) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(companyId, company.companyId) && Objects.equals(documentKey, company.documentKey)
                && Objects.equals(documentValue, company.documentValue) && Objects.equals(name, company.name)
                && Objects.equals(phone, company.phone) && Objects.equals(email, company.email)
                && Objects.equals(processes, company.processes) && Objects.equals(records, company.records)
                && Objects.equals(personsInCharge, company.personsInCharge)
                && Objects.equals(storageDeviceTypes, company.storageDeviceTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, documentKey, documentValue, name, phone, email, processes, records,
                personsInCharge, storageDeviceTypes);
    }

    @Override
    public String toString() {
        return "{" + " companyId='" + getCompanyId() + "'" + ", documentKey='" + getDocumentKey() + "'"
                + ", documentValue='" + getDocumentValue() + "'" + ", name='" + getName() + "'" + ", phone='"
                + getPhone() + "'" + ", email='" + getEmail() + "'" + ", processes='" + getProcesses() + "'"
                + ", records='" + getRecords() + "'" + ", personsInCharge='" + getPersonsInCharge() + "'"
                + ", storageDeviceTypes='" + getStorageDeviceTypes() + "'" + "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Company fromJSONString(String json) {
        String parameterOne = new JSONObject(json).getString("companyID");
        String parameterTwo = new JSONObject(json).getString("documentKey");
        String parameterThree = new JSONObject(json).getString("documentValue");
        String parameterFour = new JSONObject(json).getString("name");
        String parameterFive = new JSONObject(json).getString("phone");
        String parameterSix = new JSONObject(json).getString("email");
        String parameterSeven = new JSONObject(json).getString("processes");
        String parameterEight = new JSONObject(json).getString("records");
        String parameterNine = new JSONObject(json).getString("personsInCharge");
        String parameterTen = new JSONObject(json).getString("storageDEviceTypes");

        Company company = new Company(parameterOne, parameterTwo, parameterThree, parameterFour, parameterFive,
                parameterSix, parameterSeven, parameterEight, parameterNine, parameterTen);

        return company;
    }

}
