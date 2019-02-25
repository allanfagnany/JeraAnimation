package br.com.jera.entities

class Projects(val name: String?, val body: String) {

    companion object {

        fun getProjects() = listOf(
            Projects(Name.BEBLUE, Body.BEBLUE_BODY),
            Projects(Name.RASTROVET, Body.RASTROVET_BODY),
            Projects(Name.MAXMILHAS, Body.MAXMILHAS_BODY),
            Projects(Name.BIKXI, Body.BIKCXI_BODY),
            Projects(Name.RECLAME_AQUI, Body.RECLAME_AQUI_BODY)
        )

        object Name {
            const val BEBLUE = "Beblue"
            const val RASTROVET = "Rastrovet"
            const val MAXMILHAS = "MaxMilhas"
            const val BIKXI = "Bikxi"
            const val RECLAME_AQUI = "Reclame Aqui"
        }

        object Body {
            const val BEBLUE_BODY = "Compre nos estabelecimentos parceiros da Beblue e tenha o seu dinheiro de volta a cada compra realizada"
            const val RASTROVET_BODY = "Compre nos estabelecimentos parceiros da Beblue e tenha o seu dinheiro de volta a cada compra realizada"
            const val MAXMILHAS_BODY = "Compre nos estabelecimentos parceiros da Beblue e tenha o seu dinheiro de volta a cada compra realizada"
            const val BIKCXI_BODY = "Compre nos estabelecimentos parceiros da Beblue e tenha o seu dinheiro de volta a cada compra realizada"
            const val RECLAME_AQUI_BODY = "Pesquise a reputação de empresas, cidades e serviços públicos"
        }
    }
}