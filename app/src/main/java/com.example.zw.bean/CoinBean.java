package com.example.zw.bean;

import java.util.List;

/**
 * Created by admin on 2017/1/6.
 */

public class CoinBean {

    /**
     * SumDriveCoin : 96
     * DriveCoinSort : 4437
     * Info : [{"drivecoinnum":"1","operationdate":"2016-11-30 11:06:02","remark":"每天首次登录送1驾币"},{"drivecoinnum":"4","operationdate":"2016-11-28 10:44:17","remark":"每天首次登录送4驾币"},{"drivecoinnum":"1","operationdate":"2016-11-16 9:25:49","remark":"每天首次登录送1驾币"},{"drivecoinnum":"4","operationdate":"2016-11-8 14:02:26","remark":"每天首次登录送4驾币"},{"drivecoinnum":"4","operationdate":"2016-11-1 14:52:24","remark":"每天首次登录送4驾币"},{"drivecoinnum":"5","operationdate":"2016-10-4 10:36:12","remark":"每天首次登录送5驾币"},{"drivecoinnum":"2","operationdate":"2016-10-3 8:26:09","remark":"每天首次登录送2驾币"},{"drivecoinnum":"2","operationdate":"2016-9-21 20:43:27","remark":"每天首次登录送2驾币"},{"drivecoinnum":"2","operationdate":"2016-9-16 10:08:58","remark":"每天首次登录送2驾币"},{"drivecoinnum":"5","operationdate":"2016-9-13 14:25:03","remark":"每天首次登录送5驾币"},{"drivecoinnum":"4","operationdate":"2016-9-12 18:26:46","remark":"每天首次登录送4驾币"},{"drivecoinnum":"4","operationdate":"2016-9-11 17:03:59","remark":"每天首次登录送4驾币"},{"drivecoinnum":"4","operationdate":"2016-9-10 11:38:40","remark":"每天首次登录送4驾币"},{"drivecoinnum":"3","operationdate":"2016-8-29 8:53:12","remark":"每天首次登录送3驾币"},{"drivecoinnum":"1","operationdate":"2016-8-17 11:01:57","remark":"每天首次登录送1驾币"},{"drivecoinnum":"2","operationdate":"2016-8-16 14:03:28","remark":"每天首次登录送2驾币"},{"drivecoinnum":"1","operationdate":"2016-8-12 16:03:36","remark":"每天首次登录送1驾币"},{"drivecoinnum":"3","operationdate":"2016-8-11 11:26:35","remark":"每天首次登录送3驾币"},{"drivecoinnum":"2","operationdate":"2016-8-9 17:29:51","remark":"每天首次登录送2驾币"},{"drivecoinnum":"1","operationdate":"2016-8-8 17:28:43","remark":"每天首次登录送1驾币"}]
     */

    private String SumDriveCoin;
    private String DriveCoinSort;
    private List<InfoBean> Info;

    public String getSumDriveCoin() {
        return SumDriveCoin;
    }

    public void setSumDriveCoin(String SumDriveCoin) {
        this.SumDriveCoin = SumDriveCoin;
    }

    public String getDriveCoinSort() {
        return DriveCoinSort;
    }

    public void setDriveCoinSort(String DriveCoinSort) {
        this.DriveCoinSort = DriveCoinSort;
    }

    public List<InfoBean> getInfo() {
        return Info;
    }

    public void setInfo(List<InfoBean> Info) {
        this.Info = Info;
    }

    public static class InfoBean {
        /**
         * drivecoinnum : 1
         * operationdate : 2016-11-30 11:06:02
         * remark : 每天首次登录送1驾币
         */

        private String drivecoinnum;
        private String operationdate;
        private String remark;

        public String getDrivecoinnum() {
            return drivecoinnum;
        }

        public void setDrivecoinnum(String drivecoinnum) {
            this.drivecoinnum = drivecoinnum;
        }

        public String getOperationdate() {
            return operationdate;
        }

        public void setOperationdate(String operationdate) {
            this.operationdate = operationdate;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
