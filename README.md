# etsy-kotlin

Etsy-Kotlin is a library that can be used to access the REST-API of [ETSY](https://etsy.com).

> **NOTE:** The author of this library is not related to Etsy Ireland UC.
> It is a community project and serves only to simplify access to the ETSY Api.


## Example Usage

```kotlin
val etsyClient = EtsyClient("https://openapi.etsy.com/v3/application", System.getenv("ETSY_APIKEY"), System.getenv("ETSY_ACCESS_TOKEN"))
val etsyApi = EtsyApi(etsyClient)

```