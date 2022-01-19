package uz.elmurodov.security;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Organization {

    @SerializedName("website")
    private Object website;

    @SerializedName("reg_num")
    private String regNum;

    @SerializedName("name")
    private String name;

    @SerializedName("logo")
    private Object logo;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("location")
    private String location;

    @SerializedName("id")
    private int id;

    @SerializedName("paid_for")
    private String paidFor;

    @SerializedName("email")
    private Object email;

}