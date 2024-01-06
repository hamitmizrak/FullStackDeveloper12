// i18next
import i18n from 'i18next';

// initReactI18next
import {initReactI18next} from 'react-i18next';

// i18n.use()
i18n.use(initReactI18next).init({
    resources: {
        en:
            {
                translations: {
                      'home':'Home',
                      'about':'About',
                      'blog':'blog',
                      'newspaper':'Newspaper',
                      'contact':'Contact',
                      'login':'Login',
                      'register':'Register',
                }
            },
        tr:
            {
                translations: {
                    'home':'Anasayfa',
                    'about':'Hakkımızda',
                    'blog':'Blog',
                    'newspaper':'Haberler',
                    'contact':'İletişim',
                    'login':'Giriş',
                    'register':'Üye Ol',
                }
            }
    },
    fallbackLng: 'tr',    //default olarak Türkçe (tr)
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: {escapeValue: false, formatSeparator: ','},
    react: {
        wait: true
    }
});

// EXPORT
export default i18n;