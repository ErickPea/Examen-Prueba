function save() {
  try {
    var data = {
      "Nombre": $("#nombre_producto").val(),
      "Descripcion": $("#descripcion_id").val(), // Corregido
      "Cantidad": $("#cantidad_id").val(),
      "Precio_Decimal": $("#precio_decimal_id").val(),
      "Porcentaje": $("#porcentaje_iva_id").val(),
      "Descuento": $("#descuento_id").val(),
      "Estado": parseInt($("#Estado").val())
    };
    console.log("Datos enviados");
    console.log(data);
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: "http://localhost:8000/pruebatienda/v1/api/productos",
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
    $("#nombre_producto").val("");
    $("#descripcion_id").val("");
    $("#cantidad_id").val("");
    $("#precio_decimal_id").val("");
    $("#descuento_id").val("");
    $("#porcentaje_iva_id").val("");
    $("#Estado").val("");
    var btnAgregar = $('button[name="btnAgregar"]');
    btnAgregar.text("Agregar");
    btnAgregar.attr("onclick", "save()");
  }
  
  function loadData() {
    $.ajax({
      url: "http://localhost:8000/pruebatienda/v1/api/productos",
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
                      <td>${item.Descripcion}</td> // Corregido
                      <td>${item.Precio_Decimal}</td>
                      <td>${item.Porcentaje}</td>
                      <td>${item.Descuento}</td>
                      <td>${item.Cantidad}</td>
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
      url: "http://localhost:8000/pruebatienda/v1/api/productos/" + id,
      method: "GET",
      dataType: "json",
      success: function(response) {
        var data = response.data;
        $("#id").val(data.id);
        $("#nombre_producto").val(data.Nombre);
        $("#descripcion_id").val(data.Descripcion); // Corregido
        $("#cantidad_id").val(data.Cantidad);
        $("#precio_decimal_id").val(data.Precio_Decimal);
        $("#descuento_id").val(data.Descuento);
        $("#porcentaje_iva_id").val(data.Porcentaje);
  
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Actualizar");
        btnAgregar.attr("onclick", "update()");
      },
      error: function(error) {
        console.error("Error en la solicitud", error);
      }
    });
  }