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
import net.daw.bean.group.GroupBeanImpl;
import net.daw.helper.annotations.MethodMetaInformation;
import net.daw.helper.statics.MetaEnum;

/**
 *
 * @author Downland
 */
public class BlogBean {

    public BlogBean() {
        this.id = 0;
    }

    public BlogBean(Integer id) {
        this.id = id;
    }
    @Expose
    @MethodMetaInformation(
            IsId = true,
            UltraShortName = "Iden.",
            ShortName = "Identif.",
            Description = "Número Identificador",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id = 0; //siempre inicializar los id a 0

    @Expose
    @MethodMetaInformation(
            IsId = true,
            UltraShortName = "Iden.",
            ShortName = "Identif.",
            Description = "Número Identificador",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_categoria = 0; //siempre inicializar los id a 0

    @Expose
    @MethodMetaInformation(
            IsId = true,
            UltraShortName = "Iden.",
            ShortName = "Identif.",
            Description = "Número Identificador",
            Type = MetaEnum.FieldType.Integer,
            DefaultValue = "0"
    )
    private Integer id_documento;

    @Expose(serialize = false)
    @MethodMetaInformation(
            UltraShortName = "Iden. Preg",
            ShortName = "Iden. de Pregunta",
            Description = "Identificador de Pregunta",
            IsIdForeignKey = true,
            ReferencesTable = "pregunta",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer id_comentario = 0;
    
         
    @Expose(deserialize = false)
    @MethodMetaInformation(
            UltraShortName = "Iden. Com.",
            ShortName = "Iden. de comentario",
            Description = "Identificador de comentario",
            IsObjForeignKey = true,
            ReferencesTable = "comentario",
            MyIdName = "id_comentario"
    )
    private GroupBeanImpl obj_comentario = null;

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
    private String titulo_doc = "";

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
            UltraShortName = "Cont.",
            ShortName = "Contenido",
            Description = "Cuerpo del documento",
            Type = MetaEnum.FieldType.String,
            MinLength = 1,
            MaxLength = 999999999,
            DefaultValue = "Sin contenido"
    )
    private String contenido_doc = "";

    @Expose
    @MethodMetaInformation(
            UltraShortName = "F.alta",
            ShortName = "Fecha de alta",
            Description = "Fecha de creación del documento",
            Type = MetaEnum.FieldType.Date,
            DefaultValue = "01/01/2000",
            IsForeignKeyDescriptor = true
    )
    private Date alta_doc = new Date();

    @Expose
    @MethodMetaInformation(
            UltraShortName = "Hits",
            ShortName = "Hits",
            Description = "Número de visitas del documento",
            Type = MetaEnum.FieldType.Integer
    )
    private Integer hits_doc = 0;

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
    private String etiquetas_doc = "";
    
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
    private String autor_com;
    
    @Expose(deserialize = false)
    @MethodMetaInformation(
            UltraShortName = "Documento",
            ShortName = "Documento",
            Description = "Referencia al documento",
            IsObjForeignKey = true,
            ReferencesTable = "documento",
            MyIdName = "id_documento"
    )
    private GroupBeanImpl obj_documento = null;
    
    

}
