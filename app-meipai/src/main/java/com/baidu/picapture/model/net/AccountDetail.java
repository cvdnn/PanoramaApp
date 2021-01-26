package com.baidu.picapture.model.net;

public class AccountDetail {
    public String accountId;
    public long editionExpireAt;
    public int editionId;
    public String editionName;
    public String from;
    public String mail;
    public String phone;
    public PrivilegesBean privileges;
    public QuotaBean quota;
    public long uid;
    public String username;

    public static class PrivilegesBean {
        public GlobalBean global;
        public PanoBean pano;
        public SpinBean spin;

        public static class GlobalBean {
            public int expanStorageGB;
            public int maxStorageGB;
            public int speedUpCDN;
            public int speedUpGPU;

            public int getExpanStorageGB() {
                return this.expanStorageGB;
            }

            public int getMaxStorageGB() {
                return this.maxStorageGB;
            }

            public int getSpeedUpCDN() {
                return this.speedUpCDN;
            }

            public int getSpeedUpGPU() {
                return this.speedUpGPU;
            }

            public void setExpanStorageGB(int i2) {
                this.expanStorageGB = i2;
            }

            public void setMaxStorageGB(int i2) {
                this.maxStorageGB = i2;
            }

            public void setSpeedUpCDN(int i2) {
                this.speedUpCDN = i2;
            }

            public void setSpeedUpGPU(int i2) {
                this.speedUpGPU = i2;
            }
        }

        public static class PanoBean {
            public int copyrightMark;
            public int customContact;
            public int customCover;
            public int customCtrl;
            public int customLogo;
            public int customQR;

            public int getCopyrightMark() {
                return this.copyrightMark;
            }

            public int getCustomContact() {
                return this.customContact;
            }

            public int getCustomCover() {
                return this.customCover;
            }

            public int getCustomCtrl() {
                return this.customCtrl;
            }

            public int getCustomLogo() {
                return this.customLogo;
            }

            public int getCustomQR() {
                return this.customQR;
            }

            public void setCopyrightMark(int i2) {
                this.copyrightMark = i2;
            }

            public void setCustomContact(int i2) {
                this.customContact = i2;
            }

            public void setCustomCover(int i2) {
                this.customCover = i2;
            }

            public void setCustomCtrl(int i2) {
                this.customCtrl = i2;
            }

            public void setCustomLogo(int i2) {
                this.customLogo = i2;
            }

            public void setCustomQR(int i2) {
                this.customQR = i2;
            }
        }

        public static class SpinBean {
            public int copyrightMark;
            public int customContact;
            public int customCover;
            public int customCtrl;
            public int customLogo;
            public int customQR;
            public int cutout;
            public int export;

            public int getCopyrightMark() {
                return this.copyrightMark;
            }

            public int getCustomContact() {
                return this.customContact;
            }

            public int getCustomCover() {
                return this.customCover;
            }

            public int getCustomCtrl() {
                return this.customCtrl;
            }

            public int getCustomLogo() {
                return this.customLogo;
            }

            public int getCustomQR() {
                return this.customQR;
            }

            public int getCutout() {
                return this.cutout;
            }

            public int getExport() {
                return this.export;
            }

            public void setCopyrightMark(int i2) {
                this.copyrightMark = i2;
            }

            public void setCustomContact(int i2) {
                this.customContact = i2;
            }

            public void setCustomCover(int i2) {
                this.customCover = i2;
            }

            public void setCustomCtrl(int i2) {
                this.customCtrl = i2;
            }

            public void setCustomLogo(int i2) {
                this.customLogo = i2;
            }

            public void setCustomQR(int i2) {
                this.customQR = i2;
            }

            public void setCutout(int i2) {
                this.cutout = i2;
            }

            public void setExport(int i2) {
                this.export = i2;
            }
        }

        public GlobalBean getGlobal() {
            return this.global;
        }

        public PanoBean getPano() {
            return this.pano;
        }

        public SpinBean getSpin() {
            return this.spin;
        }

        public void setGlobal(GlobalBean globalBean) {
            this.global = globalBean;
        }

        public void setPano(PanoBean panoBean) {
            this.pano = panoBean;
        }

        public void setSpin(SpinBean spinBean) {
            this.spin = spinBean;
        }
    }

    public static class QuotaBean {
        public double usedStorageBytes;

        public double getUsedStorageBytes() {
            return this.usedStorageBytes;
        }

        public void setUsedStorageBytes(double d2) {
            this.usedStorageBytes = d2;
        }
    }

    public String getAccountId() {
        return this.accountId;
    }

    public long getEditionExpireAt() {
        return this.editionExpireAt;
    }

    public int getEditionId() {
        return this.editionId;
    }

    public String getEditionName() {
        return this.editionName;
    }

    public String getFrom() {
        return this.from;
    }

    public String getMail() {
        return this.mail;
    }

    public String getPhone() {
        return this.phone;
    }

    public PrivilegesBean getPrivileges() {
        return this.privileges;
    }

    public QuotaBean getQuota() {
        return this.quota;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setEditionExpireAt(long j2) {
        this.editionExpireAt = j2;
    }

    public void setEditionId(int i2) {
        this.editionId = i2;
    }

    public void setEditionName(String str) {
        this.editionName = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setMail(String str) {
        this.mail = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPrivileges(PrivilegesBean privilegesBean) {
        this.privileges = privilegesBean;
    }

    public void setQuota(QuotaBean quotaBean) {
        this.quota = quotaBean;
    }

    public void setUid(long j2) {
        this.uid = j2;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
