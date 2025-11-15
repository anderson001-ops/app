Postman - Instrucciones rápidas

1) Importar la colección
- Abrir Postman -> Import -> elegir `postman_collection.json` (archivo ubicado en `backend/postman_collection.json`).

2) Crear Environment local
- Variables recomendadas:
  - `baseUrl` = `http://localhost:8080`
  - `token` = ``
  - `coordToken` = ``
  - `categoryId`, `subcategoryId`, `productId`, `userId` = `` (vacíos inicialmente)

3) Ejecución básica
- Ejecutar `Auth -> Login (admin)` para obtener token. El test en la petición guardará `token` y `adminId` en el environment.
- Luego ejecutar `Categories -> Create Category` para crear una categoría. El test guardará `categoryId`.
- Ejecutar `Subcategories -> Create Subcategory` (usa `{{categoryId}}`) -> guarda `subcategoryId`.
- Ejecutar `Products -> Create Product` (usa `{{categoryId}}` y `{{subcategoryId}}`) -> guarda `productId`.
- Ejecutar endpoints GET/PUT/DELETE según la secuencia de pruebas.

4) Tips
- Asegúrate de levantar la app:

```bash
cd backend
mvn spring-boot:run
```

- Si quieres probar con el usuario COORDINADOR, ejecutar `Auth -> Login (coordinador)` y usar `coordToken` como `Authorization: Bearer {{coordToken}}` para verificar restricciones 403.
- Para ejecutar en lote: Collection Runner -> seleccionar Environment -> Run.

5) Notas
- Algunos endpoints requieren rol ADMIN (crear/eliminar usuarios, eliminar recursos). Otros permiten ADMIN y COORDINADOR (listar/crear/actualizar según controlador).
- Si tu servidor corre en otro puerto, actualiza `baseUrl` en el Environment.

Si quieres, genero también un Environment JSON listo para importar en Postman o ajusto la colección (ej. agregar tests extra o respuestas esperadas).