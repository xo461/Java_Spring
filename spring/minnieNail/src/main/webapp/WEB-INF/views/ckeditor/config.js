/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see
 *          https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here.
	// For complete reference see:
	// https://ckeditor.com/docs/ckeditor4/latest/api/CKEDITOR_config.html

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [ {
		name : 'clipboard',
		groups : [ 'clipboard', 'undo' ]
	}, {
		name : 'editing',
		groups : [ 'find', 'selection', 'spellchecker' ]
	}, {
		name : 'links'
	}, {
		name : 'insert'
	}, {
		name : 'forms'
	}, {
		name : 'tools'
	}, {
		name : 'document',
		groups : [ 'mode', 'document', 'doctools' ]
	}, {
		name : 'others'
	}, '/', {
		name : 'basicstyles',
		groups : [ 'basicstyles', 'cleanup' ]
	}, {
		name : 'paragraph',
		groups : [ 'list', 'indent', 'blocks', 'align', 'bidi' ]
	}, {
		name : 'styles'
	}, {
		name : 'colors'
	}, {
		name : 'about'
	} ];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';

	// 1.모양을 적용하기 위해 위젯 설치
	// 먼저 lineutils 와 widgetselection 설치
	config.extraPlugins = 'widget';

	// 먼저 widget 설치 부트스트랩 용
	config.extraPlugins = 'btgrid';

	// 부트스트랩 용
	config.extraPlugins = 'widgetbootstrap';

	// 코드 hightler
	config.extraPlugins = 'codesnippet';
	// config.extraPlugins = 'youtube';

	config.filebrowserUploadUrl = '${pageContext.request.contextPath}/image/imageupload.do';
	
	config.filebrowserUploadMethod = 'form';
};