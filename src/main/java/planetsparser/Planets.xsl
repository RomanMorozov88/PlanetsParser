<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!--http://www.uhlib.ru/kompyutery_i_internet/xslt/p6.php  УЧЕБНИК XSLT-->
    <xsl:template match="/PLANETS">
        <HTML>
            <HEAD>
                <TITLE>
                    The Planets Table
                </TITLE>
            </HEAD>
            <BODY>
                <H1>
                    The Planets Table
                </H1>
                <TABLE BORDER="2">
                    <TR>
                        <TD>Name</TD>
                        <TD>Mass</TD>
                        <TD>Radius</TD>
                        <TD>Day</TD>
                        <TD>Density</TD>
                        <TD>Distance</TD>
                    </TR>
                    <xsl:apply-templates/>
                </TABLE>
            </BODY>
        </HTML>
    </xsl:template>
    <xsl:template match="PLANET">
        <TR>
            <TD>
                <xsl:value-of select="NAME"/>
            </TD>
            <TD>
                <xsl:apply-templates select="MASS"/>
            </TD>
            <TD>
                <xsl:apply-templates select="RADIUS"/>
            </TD>
            <TD>
                <xsl:apply-templates select="DAY"/>
            </TD>
            <TD>
                <xsl:apply-templates select="DENSITY"/>
            </TD>
            <TD>
                <xsl:apply-templates select="DISTANCE"/>
            </TD>
        </TR>
    </xsl:template>
    <xsl:template match="MASS">
        <xsl:value-of select="."/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="@UNITS"/>
    </xsl:template>
    <xsl:template match="RADIUS">
        <xsl:value-of select="."/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="@UNITS"/>
    </xsl:template>
    <xsl:template match="DAY">
        <xsl:value-of select="."/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="@UNITS"/>
    </xsl:template>
    <xsl:template match="DENSITY">
        <xsl:value-of select="."/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="@UNITS"/>
    </xsl:template>
    <xsl:template match="DISTANCE">
        <xsl:value-of select="."/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="@UNITS"/>
    </xsl:template>
</xsl:stylesheet>