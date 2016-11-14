package recyclerviewloader.test.com.recyclerviewloader.models;

import com.google.gson.annotations.SerializedName;

import recyclerviewloader.test.com.recyclerviewloader.models.submodels.AnnouncementDate;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.AnnouncementDescription;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.AnnouncementHtml;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.AnnouncementImage;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.AnnouncementImageThumbnail;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.AnnouncementTitle;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.Expiry;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.Id;
import recyclerviewloader.test.com.recyclerviewloader.models.submodels.NativeDate;

/**
 * Created by muhammed on 11/14/2016.
 */

public class MainModels {
    @SerializedName("ID")
    private Id id;
    @SerializedName("NATIVE_DATE")
    private NativeDate nativeDate;
    @SerializedName("EXPIRY")
    private Expiry expiry;
    @SerializedName("ANNOUNCEMENT_TITLE")
    private AnnouncementTitle announcementTitle;
    @SerializedName("ANNOUNCEMENT_IMAGE_THUMBNAIL")
    private AnnouncementImageThumbnail announcementImageThumbnail;
    @SerializedName("ANNOUNCEMENT_IMAGE")
    private AnnouncementImage announcementImage;
    @SerializedName("ANNOUNCEMENT_HTML")
    private AnnouncementHtml announcementHtml;
    @SerializedName("ANNOUNCEMENT_DESCRIPTION")
    private AnnouncementDescription announcementDescription;
    @SerializedName("ANNOUNCEMENT_DATE")
    private AnnouncementDate announcementDate;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public NativeDate getNativeDate() {
        return nativeDate;
    }

    public void setNativeDate(NativeDate nativeDate) {
        this.nativeDate = nativeDate;
    }

    public Expiry getExpiry() {
        return expiry;
    }

    public void setExpiry(Expiry expiry) {
        this.expiry = expiry;
    }

    public AnnouncementTitle getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(AnnouncementTitle announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public AnnouncementImageThumbnail getAnnouncementImageThumbnail() {
        return announcementImageThumbnail;
    }

    public void setAnnouncementImageThumbnail(AnnouncementImageThumbnail announcementImageThumbnail) {
        this.announcementImageThumbnail = announcementImageThumbnail;
    }

    public AnnouncementImage getAnnouncementImage() {
        return announcementImage;
    }

    public void setAnnouncementImage(AnnouncementImage announcementImage) {
        this.announcementImage = announcementImage;
    }

    public AnnouncementHtml getAnnouncementHtml() {
        return announcementHtml;
    }

    public void setAnnouncementHtml(AnnouncementHtml announcementHtml) {
        this.announcementHtml = announcementHtml;
    }

    public AnnouncementDescription getAnnouncementDescription() {
        return announcementDescription;
    }

    public void setAnnouncementDescription(AnnouncementDescription announcementDescription) {
        this.announcementDescription = announcementDescription;
    }

    public AnnouncementDate getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(AnnouncementDate announcementDate) {
        this.announcementDate = announcementDate;
    }
}
