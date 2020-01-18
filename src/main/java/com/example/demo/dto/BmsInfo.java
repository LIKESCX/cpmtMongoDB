package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.demo.utils.TimeConvertor;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 
 */
public class BmsInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;
    /**
     * cid
     */
    private String cid;
    /**
     * eid
     */
    private String eid;

    /**
     * 运营商Id
     */
    private String operatorID;
    
    /**
     * 设备编码
     */
    
    private String equipmentID;
    /**
     * 设备接口编码
     */
    private String connectorID;
    
    /**
     * BMS编码
     */
    private String bMSCode;

    /**
     * BMS版本
     */
    private String bMSVer;

    /**
     * 最高允许充电电流
     */
    private String maxChargeCurrent;

    /**
     * 单体最高允许电压
     */
    private String maxChargeCellVoltage;

    /**
     * 最高允许温度
     */
    private String maxTemp;

    /**
     * 电池额定容量
     */
    private String ratedCapacity;

    /**
     * 总电压
     */
    private String tatalVoltage;

    /**
     * 总电流
     */
    private String totalCurrent;

    /**
     * 荷电状态
     */
    private String soc;

    /**
     * 单体最高电压
     */
    private String voltageH;

    /**
     * 单体最低电压
     */
    private String voltageL;

    /**
     * 单体最高温度
     */
    private String temptureH;

    /**
     * 单体最低温度
     */
    private String temptureL;
    
    /**
     * bms_info信息来源:'1 表示来自exc_alarm_info, 2 表示来自exc_connector_proc_data
     */
    private Integer sourceType;
    
    /**
     * 对应exc_alarm_info表中id字段
     */
    private Integer alarmInfoId;
    
    /**
     * 对应exc_connector_proc_data表中id字段
     */
    private Integer connectorProcDataId;

    /**
     * 收到时间
     */
    @JsonFormat(pattern=TimeConvertor.FORMAT_MINUS_24HOUR,timezone = "GMT+8")
    private Date receivedTime;

    /**
     * 入库时间
     */
    //@JsonFormat(pattern=TimeConvertor.FORMAT_MINUS_24HOUR,timezone = "GMT+8")
    private Date inTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public String getBMSCode() {
        return bMSCode;
    }

    public void setBMSCode(String bmsCode) {
        this.bMSCode = bmsCode;
    }

    public String getBMSVer() {
        return bMSVer;
    }

    public void setBMSVer(String bmsVer) {
        this.bMSVer = bmsVer;
    }

    public String getMaxChargeCurrent() {
        return maxChargeCurrent;
    }

    public void setMaxChargeCurrent(String maxChargeCurrent) {
        this.maxChargeCurrent = maxChargeCurrent;
    }

    public String getMaxChargeCellVoltage() {
        return maxChargeCellVoltage;
    }

    public void setMaxChargeCellVoltage(String maxChargeCellVoltage) {
        this.maxChargeCellVoltage = maxChargeCellVoltage;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getRatedCapacity() {
        return ratedCapacity;
    }

    public void setRatedCapacity(String ratedCapacity) {
        this.ratedCapacity = ratedCapacity;
    }

    public String getTatalVoltage() {
        return tatalVoltage;
    }

    public void setTatalVoltage(String tatalVoltage) {
        this.tatalVoltage = tatalVoltage;
    }

    public String getTotalCurrent() {
        return totalCurrent;
    }

    public void setTotalCurrent(String totalCurrent) {
        this.totalCurrent = totalCurrent;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getVoltageH() {
        return voltageH;
    }

    public void setVoltageH(String voltageH) {
        this.voltageH = voltageH;
    }

    public String getVoltageL() {
        return voltageL;
    }

    public void setVoltageL(String voltageL) {
        this.voltageL = voltageL;
    }

    public String getTemptureH() {
        return temptureH;
    }

    public void setTemptureH(String temptureH) {
        this.temptureH = temptureH;
    }

    public String getTemptureL() {
        return temptureL;
    }

    public void setTemptureL(String temptureL) {
        this.temptureL = temptureL;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
    
    
    public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getAlarmInfoId() {
		return alarmInfoId;
	}

	public void setAlarmInfoId(Integer alarmInfoId) {
		this.alarmInfoId = alarmInfoId;
	}

	public Integer getConnectorProcDataId() {
		return connectorProcDataId;
	}

	public void setConnectorProcDataId(Integer connectorProcDataId) {
		this.connectorProcDataId = connectorProcDataId;
	}
	
	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	@Override
	public String toString() {
		return "BmsInfo [id=" + id + ", cid=" + cid + ", eid=" + eid + ", operatorID=" + operatorID + ", equipmentID="
				+ equipmentID + ", connectorID=" + connectorID + ", bMSCode=" + bMSCode + ", bMSVer=" + bMSVer
				+ ", maxChargeCurrent=" + maxChargeCurrent + ", maxChargeCellVoltage=" + maxChargeCellVoltage
				+ ", maxTemp=" + maxTemp + ", ratedCapacity=" + ratedCapacity + ", tatalVoltage=" + tatalVoltage
				+ ", totalCurrent=" + totalCurrent + ", soc=" + soc + ", voltageH=" + voltageH + ", voltageL="
				+ voltageL + ", temptureH=" + temptureH + ", temptureL=" + temptureL + ", sourceType=" + sourceType
				+ ", alarmInfoId=" + alarmInfoId + ", connectorProcDataId=" + connectorProcDataId + ", receivedTime="
				+ receivedTime + ", inTime=" + inTime + "]";
	}
	
}