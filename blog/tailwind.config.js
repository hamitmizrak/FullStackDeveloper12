/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
      "./src/**/*.{js,jsx,ts,tsx}",
    ],
    theme: {

        container: {
            center: true
        },

        extend: {
            colors: {
                "hamitmizrak-red": "red",
                "hamitmizrak-blue": "blue",
                "hamitmizrak-yellow": "yellow",
                "hamitmizrak-gray": "#f2f2f2",
            },
            fontFamily: {
                font: ['Montserrat', 'sans-serif'],
                open: ['Open Sans', 'sans-serif'],
            }
        },
    },
    plugins: [],
}


