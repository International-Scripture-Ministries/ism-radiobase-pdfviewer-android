import { registerPlugin } from '@capacitor/core';
const PDFView = registerPlugin('PDFView', {
    web: () => import('./web').then(m => new m.PDFViewWeb()),
});
export * from './definitions';
export { PDFView };
//# sourceMappingURL=index.js.map