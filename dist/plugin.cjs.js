'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const PDFView = core.registerPlugin('PDFView', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.PDFViewWeb()),
});

class PDFViewWeb extends core.WebPlugin {
    async preview(url) {
        // console.log('ECHO', url);
        return url;
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    PDFViewWeb: PDFViewWeb
});

exports.PDFView = PDFView;
//# sourceMappingURL=plugin.cjs.js.map
