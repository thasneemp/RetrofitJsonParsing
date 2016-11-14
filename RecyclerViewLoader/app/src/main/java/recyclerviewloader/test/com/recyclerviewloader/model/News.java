
package recyclerviewloader.test.com.recyclerviewloader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class News {
    @SerializedName("ID")
    @Expose
    public ID iD;
    @SerializedName("NATIVE_DATE")
    @Expose
    public NATIVE_DATE nATIVEDATE;
    @SerializedName("ANNOUNCEMENT_DATE")
    @Expose
    public ANNOUNCEMENT_DATE aNNOUNCEMENTDATE;
    @SerializedName("EXPIRY")
    @Expose
    public EXPIRY eXPIRY;
    @SerializedName("ANNOUNCEMENT_DESCRIPTION")
    @Expose
    public ANNOUNCEMENT_DESCRIPTION aNNOUNCEMENTDESCRIPTION;
    @SerializedName("ANNOUNCEMENT_TITLE")
    @Expose
    public ANNOUNCEMENT_TITLE aNNOUNCEMENTTITLE;
    @SerializedName("ANNOUNCEMENT_IMAGE")
    @Expose
    public ANNOUNCEMENT_IMAGE aNNOUNCEMENTIMAGE;
    @SerializedName("ANNOUNCEMENT_IMAGE_THUMBNAIL")
    @Expose
    public ANNOUNCEMENT_IMAGE_THUMBNAIL aNNOUNCEMENTIMAGETHUMBNAIL;
    @SerializedName("ANNOUNCEMENT_HTML")
    @Expose
    public ANNOUNCEMENT_HTML aNNOUNCEMENTHTML;

}
