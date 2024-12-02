Feature: Agregar Producto
  Como: usuario autenticado
  Quiero: agregar productos a mi carrito
  Para: poder comprar productos

    @AñadirProducto
  Scenario Outline: Añadir exitosamente un producto
    Given el usuario esta logeado con el usuario "<username>" y contrasenia "<password>"
    And selecciona un producto
    When selecciona el boton agregar producto
    Then se agrega el producto de manera exitosa "Product added."

    Examples:
      | username    | password |
      | usuarioqwer | pass123  |


