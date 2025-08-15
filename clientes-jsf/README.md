# Clientes JSF (Jakarta EE 10) — NetBeans + Payara 6

Proyecto de ejemplo con listas en memoria:
- Listar clientes
- Agregar clientes
- Eliminar clientes

## Requisitos
- Java 17+
- NetBeans 15+
- Payara Server 6.x
- Maven

## Cómo ejecutar
1. Abrir el proyecto en NetBeans (`Abrir → Proyecto con Maven`).
2. Agregar Payara 6 en Servicios si no está agregado.
3. Run/Deploy en Payara.
4. Página de inicio: `listaClientes.xhtml`.

## Estructura
- `modelo/Cliente.java` — POJO del cliente.
- `beans/ClienteBean.java` — Lógica y lista en memoria (SessionScoped).
- `webapp/*.xhtml` — Vistas JSF.
