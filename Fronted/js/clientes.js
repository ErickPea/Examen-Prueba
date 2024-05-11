function save() {
    try {
      var data = {
        "Nombre": $("#nombre_cliente").val(),
        "Apellido": $("#apellido_id").val(),
        "TipoDocumento": $("#tipo_documento").val(),
        "Identificacion": $("#identificacion_id").val(),
        "Telefono": $("#telefono_id").val(),
        "Direccion": $("#direccion_id").val(),
        "Ciudad": $("#ciudad_id").val(),
        "Estado": parseInt($("#Estado").val())
      };
      console.log("Datos enviados");
      console.log(data);
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:8000/pruebatienda/v1/api/clientes",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsonData,
        success: function(data) {
          alert("Registro agregado con éxito");
          clearData();
          loadData();
        },
        error: function(error) {
          alert("Error no se pudo realizar el registro");
        }
      });
    } catch (error) {
      console.error("Error obteniendo el cliente", error);
    }
  }
  
  function clearData() {
    $("#id").val("");
    $("#nombre_cliente").val("");
    $("#apellido_id").val("");
    $("#tipo_documento").val("");
    $("#identificacion_id").val("");
    $("#telefono_id").val("");
    $("#direccion_id").val("");
    $("#ciudad_id").val("");
    $("#Estado").val("");
    var btnAgregar = $('button[name="btnAgregar"]');
    btnAgregar.text("Agregar");
    btnAgregar.attr("onclick", "save()");
  }
  
  function loadData() {
    $.ajax({
      url: "http://localhost:8000/pruebatienda/v1/api/clientes",
      method: "GET",
      dataType: "json",
      success: function(response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function(item) {
          if (!item.deletedAt) {
            html += `<tr>
                      <td>${item.Nombre}</td>
                      <td>${item.Apellido}</td>
                      <td>${item.TipoDocumento}</td>
                      <td>${item.Identificacion}</td>
                      <td>${item.Telefono}</td>
                      <td>${item.Direccion}</td>
                      <td>${item.Ciudad}</td>
                      <td>${item.Estado == true ? "Activo" : "Inactivo"}</td>
                      <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})">
                          <img src="../assets/icon/pencil-square.svg">
                        </button>
                        <button type="button" class="btn btn-secondary" onclick="deleteById(${item.id})">
                          <img src="../assets/icon/trash3.svg">
                        </button>
                      </td>
                    </tr>`;
          }
        });
        $("#resulData").html(html);
      },
      error: function(error) {
        console.error("Error no se pudo realizar la solicitud", error);
      }
    });
  }
  
  function findById(id) {
    $.ajax({
      url: "http://localhost:8000/pruebatienda/v1/api/clientes/" + id,
      method: "GET",
      dataType: "json",
      success: function(response) {
        var data = response.data;
        $("#id").val(data.id);
        $("#nombre_cliente").val(data.Nombre);
        $("#apellido_id").val(data.Apellido);
        $("#tipo_documento").val(data.TipoDocumento);
        $("#identificacion_id").val(data.Identificacion);
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Actualizar");
        btnAgregar.attr("onclick", "update()");
      },
      error: function(error) {
        console.error("Error en la solicitud", error);
      }
    });
  }