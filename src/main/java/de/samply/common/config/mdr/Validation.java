package de.samply.common.config.mdr;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Validation {

  @XmlElement(required = true)
  private Boolean useMdrValidation;

  @XmlElement(name = "dataElementGroup")
  private List<DataElementGroup> dataElementGroups = new ArrayList<>();

  public Boolean getUseMdrValidation() {
    return useMdrValidation;
  }

  public void setUseMdrValidation(Boolean useMdrValidation) {
    this.useMdrValidation = useMdrValidation;
  }

  public List<DataElementGroup> getDataElementGroups() {
    return dataElementGroups;
  }

  public void setDataElementGroups(List<DataElementGroup> dataElementGroups) {
    this.dataElementGroups = dataElementGroups;
  }
}
