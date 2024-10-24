<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="xsl fo">

    <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

    <!-- Definição do template principal -->
    <xsl:template match="/livro">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="pagina-principal"
                                       page-height="29.7cm"
                                       page-width="21cm"
                                       margin-top="2cm"
                                       margin-bottom="2cm"
                                       margin-left="2.5cm"
                                       margin-right="2.5cm">
                    <fo:region-body/>
                    <fo:region-before extent="1cm"/>
                    <fo:region-after extent="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="pagina-principal">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block text-align="center" font-size="10pt">
                        <xsl:text>Página </xsl:text>
                        <fo:page-number/>
                    </fo:block>
                </fo:static-content>

                <fo:flow flow-name="xsl-region-body">

                    <!-- Título do Livro -->
                    <fo:block font-size="24pt" font-weight="bold" text-align="center" space-after="20pt">
                        <xsl:value-of select="titulo"/>
                    </fo:block>

                    <!-- Iteração sobre os capítulos -->
                    <xsl:for-each select="capitulos/capitulo">
                        <!-- Título do Capítulo -->
                        <fo:block font-size="18pt" font-weight="bold" space-before="15pt" space-after="10pt">
                            <xsl:value-of select="titulo"/>
                        </fo:block>

                        <!-- Iteração sobre as páginas do capítulo -->
                        <xsl:for-each select="paginas/pagina">
                            <!-- Conteúdo da Página -->
                            <fo:block space-before="5pt" text-align="justify">
                                <fo:inline font-weight="bold">Página <xsl:value-of select="numero"/>: </fo:inline>
                                <xsl:value-of select="conteudo"/>
                            </fo:block>
                        </xsl:for-each>
                    </xsl:for-each>

                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>
