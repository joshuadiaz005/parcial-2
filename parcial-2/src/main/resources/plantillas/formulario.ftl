<#import "/plantillas/base.ftl" as base>
<div class="col-12 p-2">
</div>
    <div class="row">
        <div class="card col-10 mx-auto p-0">
            <div class="card-body">
                <h5 class="card-title">
                    ${formulario.nombre}
                    <strong class="text-warning m-0 float-right">
                        <#if tienePermisos>
                            <a href="/formulario/editar/${formulario.id}" class="text-success ml-2">
                                <i class="fas fa-edit"></i> Editar
                            </a>
                            <a href="/formulario/eliminar/${formulario.id}" class="text-primary ml-2">
                                <i class="fas fa-trash-alt"></i> Borrar
                            </a>
                        </#if>
                    </strong>
                </h5>
                <p class="card-text text-muted m-0">${formulario.sector}</p>

            </div>
        </div>
    </div>
</div>