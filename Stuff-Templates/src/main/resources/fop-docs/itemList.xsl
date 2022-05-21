<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://www.w3.org/1999/XSL/Format ">

    <xsl:template match="Items">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://www.w3.org/1999/XSL/Format ">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm"
                                       margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-name="A4">
                    <fo:flow flow-name="xsl-region-body">
                        <fo:block font-size="25pt" font-weight="bold" space-after="5mm">Anuraj Kathait</fo:block>
                        <fo:block>
                            <xsl:apply-templates select="Category"/>


                        </fo:block>
                    </fo:flow>
            </fo:page-sequence>

        </fo:root>
    </xsl:template>


    <xsl:template match="Category">
        <fo:block>
        <fo:block font-size="18pt">
            <xsl:value-of select="CategoryName"/>
        </fo:block>
        <fo:table>
            <fo:table-column column-width="60mm"/>
            <fo:table-column column-width="40mm"/>
            <fo:table-body>
                <xsl:apply-templates select="item"/>
            </fo:table-body>
        </fo:table>
        </fo:block>
    </xsl:template>


    <xsl:template match="item">
        <fo:table-row>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="name"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell>
                <fo:block>
                    <xsl:value-of select="price"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>
</xsl:stylesheet>