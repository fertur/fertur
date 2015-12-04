/*
 * Copyright (c) 2015 by Rafael Angel Aznar Aparici (rafaaznar at gmail dot com)
 * 
 * openAUSIAS: The stunning micro-library that helps you to develop easily 
 * AJAX web applications by using Java and jQuery
 * openAUSIAS is distributed under the MIT License (MIT)
 * Sources at https://github.com/rafaelaznar/openAUSIAS
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
package net.daw.bean.specific.implementation;

import com.google.gson.annotations.Expose;
import java.util.Date;
import net.daw.bean.generic.implementation.BeanGenImpl;
import net.daw.bean.group.GroupBeanImpl;
import net.daw.bean.publicinterface.BeanInterface;
import net.daw.helper.annotations.MethodMetaInformation;
import net.daw.helper.annotations.SelectSourceMetaInformation;
import net.daw.helper.statics.MetaEnum;

/**
 *
 * @author Downland
 */
@SelectSourceMetaInformation(
        SqlSelect = "SELECT d.id id_documento, d.titulo, d.contenido entrada, d.etiquetas, d.hits,c.id id_comentario, c.contenido comentario, c.nombreautor, d.alta, cat.id id_categoria, cat.nombre nombre_cat, cat.descripcion descripcion_cat FROM documento d, comentario c, documentocategoriaarticulo dca, categoriaarticulo cat WHERE d.id = c.id_documento AND dca.id_categoriaarticulo= cat.id AND d.id = dca.id_documento",
        Description = "Documento"
)

public class BlogBean extends BeanGenImpl implements BeanInterface {

    //DOCUMENTO
    @Expose
    @MethodMetaInformation(
            IsId = true,
            UltraShortName = "Iden.",
            ShortName = "Identif.",
            Description = "Número Identificador",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_documento = 0;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Tít.",
            ShortName = "Título",
            Description = "Título del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 1,
            MaxLength = 255,
            DefaultValue = "Sin título",
            IsForeignKeyDescriptor = true
    )
    private String titulo = "";

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Cont.",
            ShortName = "Contenido",
            Description = "Cuerpo del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 1,
            MaxLength = 999999999,
            DefaultValue = "Sin contenido"
    )
    private String entrada = "";

    @Expose
    @MethodMetaInformation(
            UltraShortName = "F.alta",
            ShortName = "Fecha de alta",
            Description = "Fecha de creación del documento",
            Type = MetaEnum.FieldType.Date,
            DefaultValue = "01/01/2000",
            IsForeignKeyDescriptor = true
    )
    private Date alta = new Date();

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Hits",
            ShortName = "Hits",
            Description = "Número de visitas del documento",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer hits = 0;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Etiq.",
            ShortName = "Etiquetas",
            Description = "Etiquetas del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 0,
            MaxLength = 255,
            DefaultValue = ""
    )
    private String etiquetas = "";

    //CATEGORÍA
    @Expose(serialize = false)
    @MethodMetaInformation(
            UltraShortName = "Iden. Cat",
            ShortName = "Iden. de Categoría",
            Description = "Identificador de Categoría",
            IsIdForeignKey = true,
            ReferencesTable = "categoriaarticulo",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer id_categoria = 0;

    @Expose(deserialize = false)
    @MethodMetaInformation(
            UltraShortName = "Iden. Cat",
            ShortName = "Iden. de Categoría",
            Description = "Identificador de Categoría",
            IsObjForeignKey = true,
            ReferencesTable = "categoriaarticulo",
            MyIdName = "id_categoria"
    )
    private GroupBeanImpl obj_categoria = null;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Nom.",
            ShortName = "Nombre",
            Description = "Nombre de la categoría",
            Type = MetaEnum.FieldType.String
    )
    private String nombre_cat;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Des.",
            ShortName = "Descripción",
            Description = "Descripción de la categoría",
            Type = MetaEnum.FieldType.String
    )
    private String descripcion_cat;

    //COMENTARIO
    @Expose(serialize = false)
    @MethodMetaInformation(
            UltraShortName = "Iden. Com.",
            ShortName = "Iden. de Comentario",
            Description = "Identificador de Comentario",
            IsIdForeignKey = true,
            ReferencesTable = "comentario",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer id_comentario = 0;

    @Expose(deserialize = false)
    @MethodMetaInformation(
            UltraShortName = "Iden. Com.",
            ShortName = "Iden. de Comentario",
            Description = "Identificador de Comentario",
            IsObjForeignKey = true,
            ReferencesTable = "comentario",
            MyIdName = "id_comentario"
    )
    private GroupBeanImpl obj_comentario = null;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Cont.",
            ShortName = "Contenido",
            Description = "Contenido del Comentario",
            Type = MetaEnum.FieldType.String
    )
    private String comentario;

    @Expose
    @MethodMetaInformation(
            UltraShortName = "NomAut.",
            ShortName = "Nombre Autor",
            Description = "Nombre del autor del comentario",
            Type = MetaEnum.FieldType.String
    )
    private String nombreautor;

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public GroupBeanImpl getObj_categoria() {
        return obj_categoria;
    }

    public void setObj_categoria(GroupBeanImpl obj_categoria) {
        this.obj_categoria = obj_categoria;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public String getDescripcion_cat() {
        return descripcion_cat;
    }

    public void setDescripcion_cat(String descripcion_cat) {
        this.descripcion_cat = descripcion_cat;
    }

    public Integer getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Integer id_comentario) {
        this.id_comentario = id_comentario;
    }

    public GroupBeanImpl getObj_comentario() {
        return obj_comentario;
    }

    public void setObj_comentario(GroupBeanImpl obj_comentario) {
        this.obj_comentario = obj_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombreautor() {
        return nombreautor;
    }

    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
    }

}
