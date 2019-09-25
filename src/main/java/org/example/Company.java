/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
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


    public Company() {
    }

    public Company(String companyId, String documentKey, String documentValue, String name, String phone, String email) {
        this.companyId = companyId;
        this.documentKey = documentKey;
        this.documentValue = documentValue;
        this.name = name;
        this.phone = phone;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Company)) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(companyId, company.companyId) && Objects.equals(documentKey, company.documentKey) && Objects.equals(documentValue, company.documentValue) && Objects.equals(name, company.name) && Objects.equals(phone, company.phone) && Objects.equals(email, company.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, documentKey, documentValue, name, phone, email);
    }

    @Override
    public String toString() {
        return "{" +
            " companyId='" + getCompanyId() + "'" +
            ", documentKey='" + getDocumentKey() + "'" +
            ", documentValue='" + getDocumentValue() + "'" +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
    

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

}
