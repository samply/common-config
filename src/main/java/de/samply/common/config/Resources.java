/*
 * Copyright (C) 2015 Working Group on Joint Research, University Medical Center Mainz
 * Copyright (C) since 2016 The Samply Community
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7:
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Jersey (https://jersey.java.net) (or a modified version of that
 * library), containing parts covered by the terms of the General Public
 * License, version 2.0, the licensors of this Program grant you additional
 * permission to convey the resulting work.
 */

package de.samply.common.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="resourceType" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="field" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *                           &lt;attribute name="type" use="required" type="{http://schema.samply.de/config/Resources}fieldType" /&gt;
 *                           &lt;attribute name="maxLength" type="{http://www.w3.org/2001/XMLSchema}int" default="0" /&gt;
 *                           &lt;attribute name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *                           &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
 *                           &lt;attribute name="unique" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="relation" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *                           &lt;attribute name="type" use="required" type="{http://schema.samply.de/config/Resources}relationType" /&gt;
 *                           &lt;attribute name="onDeleteCascade" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *                 &lt;attribute name="versioned" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *                 &lt;attribute name="resource" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resourceType"
})
@XmlRootElement(name = "resources", namespace = "http://schema.samply.de/config/Resources")
public class Resources {

    @XmlElement(namespace = "http://schema.samply.de/config/Resources", required = true)
    protected List<Resources.ResourceType> resourceType;

    /**
     * Gets the value of the resourceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resources.ResourceType }
     * 
     * 
     */
    public List<Resources.ResourceType> getResourceType() {
        if (resourceType == null) {
            resourceType = new ArrayList<Resources.ResourceType>();
        }
        return this.resourceType;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="field" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
     *                 &lt;attribute name="type" use="required" type="{http://schema.samply.de/config/Resources}fieldType" /&gt;
     *                 &lt;attribute name="maxLength" type="{http://www.w3.org/2001/XMLSchema}int" default="0" /&gt;
     *                 &lt;attribute name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
     *                 &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
     *                 &lt;attribute name="unique" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="relation" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
     *                 &lt;attribute name="type" use="required" type="{http://schema.samply.de/config/Resources}relationType" /&gt;
     *                 &lt;attribute name="onDeleteCascade" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
     *       &lt;attribute name="versioned" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
     *       &lt;attribute name="resource" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "field",
        "relation"
    })
    public static class ResourceType {

        @XmlElement(namespace = "http://schema.samply.de/config/Resources")
        protected List<Resources.ResourceType.Field> field;
        @XmlElement(namespace = "http://schema.samply.de/config/Resources")
        protected List<Resources.ResourceType.Relation> relation;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NCName")
        protected String name;
        @XmlAttribute(name = "versioned")
        protected Boolean versioned;
        @XmlAttribute(name = "resource")
        protected Boolean resource;

        /**
         * Gets the value of the field property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the field property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Resources.ResourceType.Field }
         * 
         * 
         */
        public List<Resources.ResourceType.Field> getField() {
            if (field == null) {
                field = new ArrayList<Resources.ResourceType.Field>();
            }
            return this.field;
        }

        /**
         * Gets the value of the relation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the relation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRelation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Resources.ResourceType.Relation }
         * 
         * 
         */
        public List<Resources.ResourceType.Relation> getRelation() {
            if (relation == null) {
                relation = new ArrayList<Resources.ResourceType.Relation>();
            }
            return this.relation;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the versioned property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isVersioned() {
            if (versioned == null) {
                return true;
            } else {
                return versioned;
            }
        }

        /**
         * Sets the value of the versioned property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setVersioned(Boolean value) {
            this.versioned = value;
        }

        /**
         * Gets the value of the resource property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isResource() {
            if (resource == null) {
                return true;
            } else {
                return resource;
            }
        }

        /**
         * Sets the value of the resource property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setResource(Boolean value) {
            this.resource = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
         *       &lt;attribute name="type" use="required" type="{http://schema.samply.de/config/Resources}fieldType" /&gt;
         *       &lt;attribute name="maxLength" type="{http://www.w3.org/2001/XMLSchema}int" default="0" /&gt;
         *       &lt;attribute name="mandatory" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
         *       &lt;attribute name="default" type="{http://www.w3.org/2001/XMLSchema}string" default="" /&gt;
         *       &lt;attribute name="unique" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Field {

            @XmlAttribute(name = "name", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String name;
            @XmlAttribute(name = "type", required = true)
            protected FieldType type;
            @XmlAttribute(name = "maxLength")
            protected Integer maxLength;
            @XmlAttribute(name = "mandatory")
            protected Boolean mandatory;
            @XmlAttribute(name = "default")
            protected String _default;
            @XmlAttribute(name = "unique")
            protected Boolean unique;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link FieldType }
             *     
             */
            public FieldType getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link FieldType }
             *     
             */
            public void setType(FieldType value) {
                this.type = value;
            }

            /**
             * Gets the value of the maxLength property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public int getMaxLength() {
                if (maxLength == null) {
                    return  0;
                } else {
                    return maxLength;
                }
            }

            /**
             * Sets the value of the maxLength property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setMaxLength(Integer value) {
                this.maxLength = value;
            }

            /**
             * Gets the value of the mandatory property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public boolean isMandatory() {
                if (mandatory == null) {
                    return true;
                } else {
                    return mandatory;
                }
            }

            /**
             * Sets the value of the mandatory property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setMandatory(Boolean value) {
                this.mandatory = value;
            }

            /**
             * Gets the value of the default property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDefault() {
                if (_default == null) {
                    return "";
                } else {
                    return _default;
                }
            }

            /**
             * Sets the value of the default property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDefault(String value) {
                this._default = value;
            }

            /**
             * Gets the value of the unique property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public boolean isUnique() {
                if (unique == null) {
                    return false;
                } else {
                    return unique;
                }
            }

            /**
             * Sets the value of the unique property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setUnique(Boolean value) {
                this.unique = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
         *       &lt;attribute name="type" use="required" type="{http://schema.samply.de/config/Resources}relationType" /&gt;
         *       &lt;attribute name="onDeleteCascade" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Relation {

            @XmlAttribute(name = "to", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String to;
            @XmlAttribute(name = "type", required = true)
            protected RelationType type;
            @XmlAttribute(name = "onDeleteCascade")
            protected Boolean onDeleteCascade;
            @XmlAttribute(name = "name")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NCName")
            protected String name;

            /**
             * Gets the value of the to property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTo() {
                return to;
            }

            /**
             * Sets the value of the to property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTo(String value) {
                this.to = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link RelationType }
             *     
             */
            public RelationType getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link RelationType }
             *     
             */
            public void setType(RelationType value) {
                this.type = value;
            }

            /**
             * Gets the value of the onDeleteCascade property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public boolean isOnDeleteCascade() {
                if (onDeleteCascade == null) {
                    return true;
                } else {
                    return onDeleteCascade;
                }
            }

            /**
             * Sets the value of the onDeleteCascade property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setOnDeleteCascade(Boolean value) {
                this.onDeleteCascade = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }

    }

}
