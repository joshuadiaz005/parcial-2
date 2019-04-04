    <div class="col-12 p-2">
        <div class="row">
            <#list formularios as formulario>
                <div class="col-12  p-0">
                    <div class="card-footer mx-1 mb-5">
                        <div class="card-body">
                            <h5 class="card-title">${formulario.nombre}</h5>
                            <p class="card-text text-muted m-0">${formulario.sector}</p>
                            <p class="card-text text-muted m-0">${formulario.sector}</p>
                            <a href="/formulario/${formulario.id}" class="text-danger float-right"><strong>Leer más...</strong></a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>