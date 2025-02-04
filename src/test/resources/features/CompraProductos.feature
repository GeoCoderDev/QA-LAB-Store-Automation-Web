#language: es

@Compra_Productos
Característica: Compra de Productos

  @t1
  Esquema del escenario: Validación del precio de un producto

    Dado estoy en la página de la tienda
    Y me logueo con mi correo "<email>" y clave "<password>"
    Cuando navego a la categoria "<category>" y subcategoria "<subcategory>"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando  finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

    Ejemplos:
      | email                        | password      | category | subcategory |
      | juanchavezsaldana@gmail.com  | Jam09@csn3871 | CLOTHES  | MEN         |
      | correoNoRegistrado@gmail.com | 12345678      | CLOTHES  | MEN         |
      | juanchavezsaldana@gmail.com  | Jam09@csn3871 | Autos    | Costosos    |

