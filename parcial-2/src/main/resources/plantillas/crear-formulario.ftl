<#--<#import "base.ftl" as base>-->
<#--<@base.pagina>-->

    <!doctype html>
    <html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Parcial2</title>
        <link rel="stylesheet" href="/estilos/estilo.css">

        <!-- Font Awesome 5 -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

        <!-- Bootstrap 4 CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

        <!-- Bootstrap 4 JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    </head>
    <body >
    <div class="col-lg-8 col-md-10 col-sm-12 mx-auto">
        <div class="row">
            <div class="col-12 mt-2 bg-light px-4 rounded-0 login">
                <div class="row">
                    <form class="col-12" id="form">
                        <div class="panel px-2 py-3 bg-white">
                            <label for="nombre"><strong>Nombre</strong> </label>
                            <input type="text" class="form-control rounded-0" name="nombre" id="nombre" placeholder="Nombre" required autofocus/>
                            <br>
                            <label for="cuerpo"><strong>Sector</strong></label><br>
                            <textarea name="sector" id="sector" class="form-control rounded-0"></textarea>
                            <br>
                            <label for="titulo"><strong>Nivel Escolar</strong></label><br>
                            <input name="nivelEscolar" id="nivelEscolar" class="form-control rounded-0"></input>
                            <br>
                            <label for="latitud"><strong>Latitud</strong></label><br>
                            <input name="latitud" id="latitud" class="form-control rounded-0"></input>
                            <br>
                            <label for="longitud"><strong>Longitud</strong></label><br>
                            <input name="longitud" id="longitud" class="form-control rounded-0"></input>
                            <br>
                        </div>
                        <button class="btn btn-outline-dark btn-block my-3" type="submit">
                            Registrar
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<#--</@base.pagina>-->
<script src="https://unpkg.com/dexie@latest/dist/dexie.js"></script>
<script>
    let posicion = [], latitud, longitud;
    $(document).ready(function (){
        $("#form").submit(function () {
            enviarFormuarios();
            return false;
        })
    });
    function enviarFormuarios(){
        let db = new Dexie("form");
        db.version(1).stores({
            form: '++id, nombre, sector, nivelEscolar, latitud, longitud, eliminado'
        });

        db.form.add({
            nombre: $('#nombre').val(),
            sector: $('#sector').val(),
            nivelEscolar: $('#nivelEscolar').val(),
            latitud: latitud,
            longitud: longitud,
            eliminado: false
        });

        window.location.href = 'listar';


    }
</script>
</body>
</html>