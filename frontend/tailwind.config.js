/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        /* Fondo pagina autentifcacion */
        'colorAuthPageBgGradient1': '#00beff',
        'colorAuthPageBgGradient2': '#03b08b',
        'colorAuthPageBgGradient3': '#41b68d',
        /* Fondo pagina principal */
        'colorMainPageBgGradient1': '#00beff',
        'colorMainPageBgGradient2': '#03b08b',
        'colorMainPageBgGradient3': '#41b68d',
       /* titulos de las páginas */
        'colorTextTitle': '#000000',
        /* texto general */
        'colorTextLabel': '#000000',
        'colorTextValue': '#444444',
        /* Panel páginas */
        'colorPagePanel': '#c9c9c9',
        'colorPagePanelResp': '#ffffff',
        /* Colores boton */
        'colorButtonOk': '#1fb6ff',
        'colorButtonWrong': '#ec5b5b',
        'colorTextButtonOk': '#ffffff',
        'colorTextButtonWrong': '#ffffff',
        /* Colores inputs*/
        'colorInput': '#ffffff',
        'colorTextInput': '#000000',
        'colorTextInputTitle': '#000000',
        /* Colores barra de navegacion */
        'colorNavBar': '#104bc5',
        'colorNavBarButton': '#2987ff',
        'colorTextNavBarButton': '#000000',
        'colorTextNavBarButtonHover': '#ffffff',
        /* Boton subir imagenes */
        'colorUploadImgBg': '#424242',
        'colorUploadImgText': 'rgb(255,255,255)',
        /* Paginación */
        'colorPaginationPage': '#424242',
        'colorPaginationButtons': '#000000',
        /* color mostrar/ocultar compras/ventas*/
        'colorShowHideBuys': 'rgb(0,0,0)',
        /* resultados buscar anuncios*/
        'colorResultadoBuscarAnunciosBg': '#e0e0e0',
        'colorResultadoBuscarAnunciosBgSel': 'rgb(171,171,171)',
        'colorResultadoBuscarAnunciosDesBg': 'rgb(178,178,178)',
        'colorResultadoBuscarAnunciosDesBgSel': 'rgb(178,178,178)',
        'colorResultadoBuscarAnunciosTitle': 'rgb(0,0,0)',
        'colorResultadoBuscarAnunciosDesText': 'rgb(0,0,0)',
        'colorResultadoBuscarAnunciosTag': 'rgb(0,0,0)',
        'colorResultadoBuscarAnunciosValue': 'rgb(52,52,52)',
        'colorResultadoBuscarAnunciosPriceSel': 'rgb(192,65,65)',
        'colorResultadoBuscarAnunciosPriceNotSel': 'rgb(40,194,105)',
        /* resultados buscar Responsive pequeño*/
        'colorResultadoBuscarAnunciosRespBg': 'rgb(255,255,255)',
        'colorResultadoBuscarAnunciosRespDesBg': 'rgb(199,194,194)',
        /* Reviews */
        'colorReviewUsr': 'rgb(0,0,0)',
        'colorReviewMsg': 'rgb(37,37,37)',
        'colorReviewBg': 'rgb(231,231,231)',
        'colorReviewFormBg': 'rgb(241,241,241)',
      },
    },
  },
  plugins: [],
}

