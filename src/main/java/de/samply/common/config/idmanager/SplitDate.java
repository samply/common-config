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

package de.samply.common.config.idmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for SplitDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SplitDate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="Input" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Output"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SplitDate", propOrder = {

})
public class SplitDate {

    @XmlElement(name = "Input", required = true)
    protected String input;
    @XmlElement(name = "Format", required = true)
    protected String format;
    @XmlElement(name = "Output", required = true)
    protected SplitDate.Output output;

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInput(String value) {
        this.input = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link SplitDate.Output }
     *     
     */
    public SplitDate.Output getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link SplitDate.Output }
     *     
     */
    public void setOutput(SplitDate.Output value) {
        this.output = value;
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
     *       &lt;all&gt;
     *         &lt;element name="Day" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Output {

        @XmlElement(name = "Day", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String day;
        @XmlElement(name = "Month", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String month;
        @XmlElement(name = "Year", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String year;

        /**
         * Gets the value of the day property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDay() {
            return day;
        }

        /**
         * Sets the value of the day property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDay(String value) {
            this.day = value;
        }

        /**
         * Gets the value of the month property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMonth() {
            return month;
        }

        /**
         * Sets the value of the month property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMonth(String value) {
            this.month = value;
        }

        /**
         * Gets the value of the year property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getYear() {
            return year;
        }

        /**
         * Sets the value of the year property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setYear(String value) {
            this.year = value;
        }

    }

}
