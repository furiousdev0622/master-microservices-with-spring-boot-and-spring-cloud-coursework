package com.in28minutes.rest.webservices.restfulwebservices.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

// You can add multiple fields here if you prefer
// @JsonIgnoreProperties("field1")

@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    // Field below annotation not returned
    // @JsonIgnore
    private String field2;
    private String field3;

    public SomeBean() {
    }

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeBean someBean = (SomeBean) o;
        return Objects.equals(field1, someBean.field1) && Objects.equals(field2, someBean.field2) && Objects.equals(field3, someBean.field3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3);
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
