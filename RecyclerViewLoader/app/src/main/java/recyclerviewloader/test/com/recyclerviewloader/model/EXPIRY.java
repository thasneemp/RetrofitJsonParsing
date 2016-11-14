
package recyclerviewloader.test.com.recyclerviewloader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EXPIRY {

    @SerializedName("Tag")
    @Expose
    public String tag;
    @SerializedName("TypeCode")
    @Expose
    public Integer typeCode;
    @SerializedName("Value")
    @Expose
    public String value;
    @SerializedName("IsBinaryUnique")
    @Expose
    public Boolean isBinaryUnique;

}
