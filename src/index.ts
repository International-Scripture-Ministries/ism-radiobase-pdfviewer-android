import { registerPlugin } from '@capacitor/core';

import type { PDFViewPlugin } from './definitions';

const PDFView = registerPlugin<PDFViewPlugin>('PDFView', {
  web: () => import('./web').then(m => new m.PDFViewWeb()),
});

export * from './definitions';
export { PDFView };
