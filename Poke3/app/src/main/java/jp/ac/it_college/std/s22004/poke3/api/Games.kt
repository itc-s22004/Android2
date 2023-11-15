package jp.ac.it_college.std.s22004.poke3.api
import io.ktor.client.call.body
import jp.ac.it_college.std.s22004.poke3.model.Generation
import jp.ac.it_college.std.s22004.poke3.model.Name
import jp.ac.it_college.std.s22004.poke3.model.NamedApiResource
import jp.ac.it_college.std.s22004.poke3.model.NamedApiResourceList

/**
 * PokeAPI の Games カテゴリにあるエンドポイントへのアクセスを実装
 *
 * いま時点では、世代の一覧を取る機能のみ
 */
object Games {
    /**
     * /generation エンドポイントへパラメータなしだと
     * [NamedApiResourceList] 型で取得できる。
     */
    public suspend fun getGenerations(): NamedApiResourceList {
        return ApiClient.get("/generation").body()
    }
    public suspend fun getPokemon(): Generation {
        return ApiClient.get("/generation/1").body()
    }
}