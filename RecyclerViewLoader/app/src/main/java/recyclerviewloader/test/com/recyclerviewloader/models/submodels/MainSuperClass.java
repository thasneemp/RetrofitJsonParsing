package recyclerviewloader.test.com.recyclerviewloader.models.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammed on 11/14/2016.
 */

public class MainSuperClass {
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIsBinaryUnique() {
        return isBinaryUnique;
    }

    public void setIsBinaryUnique(String isBinaryUnique) {
        this.isBinaryUnique = isBinaryUnique;
    }

    @SerializedName("Tag")
    private String tag;
    @SerializedName("TypeCode")
    private String typeCode;
    @SerializedName("Value")
    private String value;
    @SerializedName("IsBinaryUnique")
    private String isBinaryUnique;

}
