import { WebPlugin } from '@capacitor/core';
export class PDFViewWeb extends WebPlugin {
    async preview(url) {
        // console.log('ECHO', url);
        return url;
    }
}
//# sourceMappingURL=web.js.map