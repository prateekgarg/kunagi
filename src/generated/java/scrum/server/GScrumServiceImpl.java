// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtServiceImplGenerator










package scrum.server;

import java.util.*;

public abstract class GScrumServiceImpl
            extends ilarkesto.gwt.server.AGwtServiceImpl
            implements scrum.client.ScrumService {

    protected abstract void onChangePassword(GwtConversation conversation, java.lang.String newPassword, java.lang.String oldPassword);

    @Override
    public scrum.client.DataTransferObject changePassword(int conversationNumber, java.lang.String newPassword, java.lang.String oldPassword) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: changePassword");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall changePassword waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:changePassword");
            context.bindCurrentThread();
            try {
                onChangePassword(conversation, newPassword, oldPassword);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "changePassword", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("changePassword")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"changePassword", newPassword, oldPassword, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"changePassword", newPassword, oldPassword);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onLogout(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject logout(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: logout");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall logout waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:logout");
            context.bindCurrentThread();
            try {
                onLogout(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "logout", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("logout")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"logout", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"logout");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onResetPassword(GwtConversation conversation, java.lang.String userId);

    @Override
    public scrum.client.DataTransferObject resetPassword(int conversationNumber, java.lang.String userId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: resetPassword");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall resetPassword waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:resetPassword");
            context.bindCurrentThread();
            try {
                onResetPassword(conversation, userId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "resetPassword", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("resetPassword")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"resetPassword", userId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"resetPassword", userId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onSendTestEmail(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject sendTestEmail(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: sendTestEmail");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:sendTestEmail");
            context.bindCurrentThread();
            try {
                onSendTestEmail(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "sendTestEmail", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("sendTestEmail")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"sendTestEmail", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"sendTestEmail");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onTestLdap(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject testLdap(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: testLdap");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:testLdap");
            context.bindCurrentThread();
            try {
                onTestLdap(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "testLdap", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("testLdap")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"testLdap", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"testLdap");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onUpdateSystemMessage(GwtConversation conversation, scrum.client.admin.SystemMessage systemMessage);

    @Override
    public scrum.client.DataTransferObject updateSystemMessage(int conversationNumber, scrum.client.admin.SystemMessage systemMessage) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: updateSystemMessage");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall updateSystemMessage waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:updateSystemMessage");
            context.bindCurrentThread();
            try {
                onUpdateSystemMessage(conversation, systemMessage);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "updateSystemMessage", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("updateSystemMessage")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"updateSystemMessage", systemMessage, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"updateSystemMessage", systemMessage);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestComments(GwtConversation conversation, java.lang.String parentId);

    @Override
    public scrum.client.DataTransferObject requestComments(int conversationNumber, java.lang.String parentId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestComments");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestComments");
            context.bindCurrentThread();
            try {
                onRequestComments(conversation, parentId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestComments", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestComments")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestComments", parentId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestComments", parentId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestForum(GwtConversation conversation, boolean all);

    @Override
    public scrum.client.DataTransferObject requestForum(int conversationNumber, boolean all) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestForum");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestForum");
            context.bindCurrentThread();
            try {
                onRequestForum(conversation, all);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestForum", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestForum")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestForum", all, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestForum", all);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onPing(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject ping(int conversationNumber) {
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:ping");
            context.bindCurrentThread();
            try {
                onPing(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "ping", ex, context);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onStartConversation(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject startConversation(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: startConversation");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall startConversation waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:startConversation");
            context.bindCurrentThread();
            try {
                onStartConversation(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "startConversation", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("startConversation")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"startConversation", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"startConversation");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onTouchLastActivity(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject touchLastActivity(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: touchLastActivity");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall touchLastActivity waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:touchLastActivity");
            context.bindCurrentThread();
            try {
                onTouchLastActivity(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "touchLastActivity", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("touchLastActivity")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"touchLastActivity", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"touchLastActivity");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onChangeProperties(GwtConversation conversation, java.util.Map<String, String> properties);

    @Override
    public scrum.client.DataTransferObject changeProperties(int conversationNumber, java.util.Map<String, String> properties) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: changeProperties");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall changeProperties waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:changeProperties");
            context.bindCurrentThread();
            try {
                onChangeProperties(conversation, properties);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "changeProperties", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("changeProperties")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"changeProperties", properties, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"changeProperties", properties);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onCreateEntity(GwtConversation conversation, java.lang.String type, java.util.Map<String, String> properties);

    @Override
    public scrum.client.DataTransferObject createEntity(int conversationNumber, java.lang.String type, java.util.Map<String, String> properties) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: createEntity");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall createEntity waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:createEntity");
            context.bindCurrentThread();
            try {
                onCreateEntity(conversation, type, properties);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "createEntity", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("createEntity")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"createEntity", type, properties, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"createEntity", type, properties);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onDeleteEntity(GwtConversation conversation, java.lang.String entityId);

    @Override
    public scrum.client.DataTransferObject deleteEntity(int conversationNumber, java.lang.String entityId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: deleteEntity");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall deleteEntity waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:deleteEntity");
            context.bindCurrentThread();
            try {
                onDeleteEntity(conversation, entityId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "deleteEntity", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("deleteEntity")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"deleteEntity", entityId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"deleteEntity", entityId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestEntity(GwtConversation conversation, java.lang.String entityId);

    @Override
    public scrum.client.DataTransferObject requestEntity(int conversationNumber, java.lang.String entityId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestEntity");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestEntity");
            context.bindCurrentThread();
            try {
                onRequestEntity(conversation, entityId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestEntity", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestEntity")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestEntity", entityId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestEntity", entityId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestEntityByReference(GwtConversation conversation, java.lang.String reference);

    @Override
    public scrum.client.DataTransferObject requestEntityByReference(int conversationNumber, java.lang.String reference) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestEntityByReference");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestEntityByReference");
            context.bindCurrentThread();
            try {
                onRequestEntityByReference(conversation, reference);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestEntityByReference", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestEntityByReference")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestEntityByReference", reference, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestEntityByReference", reference);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onSleep(GwtConversation conversation, long millis);

    @Override
    public scrum.client.DataTransferObject sleep(int conversationNumber, long millis) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: sleep");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:sleep");
            context.bindCurrentThread();
            try {
                onSleep(conversation, millis);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "sleep", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("sleep")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"sleep", millis, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"sleep", millis);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onActivateRequirementEstimationVoting(GwtConversation conversation, java.lang.String requirementId);

    @Override
    public scrum.client.DataTransferObject activateRequirementEstimationVoting(int conversationNumber, java.lang.String requirementId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: activateRequirementEstimationVoting");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall activateRequirementEstimationVoting waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:activateRequirementEstimationVoting");
            context.bindCurrentThread();
            try {
                onActivateRequirementEstimationVoting(conversation, requirementId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "activateRequirementEstimationVoting", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("activateRequirementEstimationVoting")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"activateRequirementEstimationVoting", requirementId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"activateRequirementEstimationVoting", requirementId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestRequirementEstimationVotes(GwtConversation conversation, java.lang.String requirementId);

    @Override
    public scrum.client.DataTransferObject requestRequirementEstimationVotes(int conversationNumber, java.lang.String requirementId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestRequirementEstimationVotes");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestRequirementEstimationVotes");
            context.bindCurrentThread();
            try {
                onRequestRequirementEstimationVotes(conversation, requirementId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestRequirementEstimationVotes", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestRequirementEstimationVotes")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestRequirementEstimationVotes", requirementId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestRequirementEstimationVotes", requirementId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestImpediments(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject requestImpediments(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestImpediments");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestImpediments");
            context.bindCurrentThread();
            try {
                onRequestImpediments(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestImpediments", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestImpediments")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestImpediments", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestImpediments");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onConvertIssueToStory(GwtConversation conversation, java.lang.String issueId);

    @Override
    public scrum.client.DataTransferObject convertIssueToStory(int conversationNumber, java.lang.String issueId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: convertIssueToStory");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall convertIssueToStory waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:convertIssueToStory");
            context.bindCurrentThread();
            try {
                onConvertIssueToStory(conversation, issueId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "convertIssueToStory", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("convertIssueToStory")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"convertIssueToStory", issueId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"convertIssueToStory", issueId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestAcceptedIssues(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject requestAcceptedIssues(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestAcceptedIssues");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestAcceptedIssues");
            context.bindCurrentThread();
            try {
                onRequestAcceptedIssues(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestAcceptedIssues", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestAcceptedIssues")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestAcceptedIssues", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestAcceptedIssues");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestClosedIssues(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject requestClosedIssues(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestClosedIssues");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestClosedIssues");
            context.bindCurrentThread();
            try {
                onRequestClosedIssues(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestClosedIssues", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestClosedIssues")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestClosedIssues", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestClosedIssues");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestReleaseIssues(GwtConversation conversation, java.lang.String releaseId);

    @Override
    public scrum.client.DataTransferObject requestReleaseIssues(int conversationNumber, java.lang.String releaseId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestReleaseIssues");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestReleaseIssues");
            context.bindCurrentThread();
            try {
                onRequestReleaseIssues(conversation, releaseId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestReleaseIssues", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestReleaseIssues")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestReleaseIssues", releaseId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestReleaseIssues", releaseId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onSendIssueReplyEmail(GwtConversation conversation, java.lang.String issueId, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text);

    @Override
    public scrum.client.DataTransferObject sendIssueReplyEmail(int conversationNumber, java.lang.String issueId, java.lang.String from, java.lang.String to, java.lang.String subject, java.lang.String text) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: sendIssueReplyEmail");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall sendIssueReplyEmail waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:sendIssueReplyEmail");
            context.bindCurrentThread();
            try {
                onSendIssueReplyEmail(conversation, issueId, from, to, subject, text);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "sendIssueReplyEmail", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("sendIssueReplyEmail")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"sendIssueReplyEmail", issueId, from, to, subject, text, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"sendIssueReplyEmail", issueId, from, to, subject, text);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestChanges(GwtConversation conversation, java.lang.String parentId);

    @Override
    public scrum.client.DataTransferObject requestChanges(int conversationNumber, java.lang.String parentId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestChanges");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestChanges");
            context.bindCurrentThread();
            try {
                onRequestChanges(conversation, parentId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestChanges", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestChanges")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestChanges", parentId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestChanges", parentId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestProjectEvents(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject requestProjectEvents(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestProjectEvents");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestProjectEvents");
            context.bindCurrentThread();
            try {
                onRequestProjectEvents(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestProjectEvents", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestProjectEvents")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestProjectEvents", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestProjectEvents");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onCloseProject(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject closeProject(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: closeProject");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall closeProject waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:closeProject");
            context.bindCurrentThread();
            try {
                onCloseProject(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "closeProject", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("closeProject")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"closeProject", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"closeProject");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onCreateExampleProject(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject createExampleProject(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: createExampleProject");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall createExampleProject waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:createExampleProject");
            context.bindCurrentThread();
            try {
                onCreateExampleProject(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "createExampleProject", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("createExampleProject")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"createExampleProject", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"createExampleProject");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onDeleteStory(GwtConversation conversation, java.lang.String storyId);

    @Override
    public scrum.client.DataTransferObject deleteStory(int conversationNumber, java.lang.String storyId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: deleteStory");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall deleteStory waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:deleteStory");
            context.bindCurrentThread();
            try {
                onDeleteStory(conversation, storyId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "deleteStory", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("deleteStory")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"deleteStory", storyId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"deleteStory", storyId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onMoveRequirementToProject(GwtConversation conversation, java.lang.String destinationProjectId, java.lang.String requirementId);

    @Override
    public scrum.client.DataTransferObject moveRequirementToProject(int conversationNumber, java.lang.String destinationProjectId, java.lang.String requirementId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: moveRequirementToProject");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall moveRequirementToProject waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:moveRequirementToProject");
            context.bindCurrentThread();
            try {
                onMoveRequirementToProject(conversation, destinationProjectId, requirementId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "moveRequirementToProject", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("moveRequirementToProject")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"moveRequirementToProject", destinationProjectId, requirementId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"moveRequirementToProject", destinationProjectId, requirementId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onSelectProject(GwtConversation conversation, java.lang.String projectId);

    @Override
    public scrum.client.DataTransferObject selectProject(int conversationNumber, java.lang.String projectId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: selectProject");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall selectProject waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:selectProject");
            context.bindCurrentThread();
            try {
                onSelectProject(conversation, projectId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "selectProject", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("selectProject")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"selectProject", projectId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"selectProject", projectId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onUpdateProjectHomepage(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject updateProjectHomepage(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: updateProjectHomepage");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:updateProjectHomepage");
            context.bindCurrentThread();
            try {
                onUpdateProjectHomepage(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "updateProjectHomepage", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("updateProjectHomepage")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"updateProjectHomepage", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"updateProjectHomepage");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onPublishRelease(GwtConversation conversation, java.lang.String releaseId);

    @Override
    public scrum.client.DataTransferObject publishRelease(int conversationNumber, java.lang.String releaseId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: publishRelease");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall publishRelease waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:publishRelease");
            context.bindCurrentThread();
            try {
                onPublishRelease(conversation, releaseId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "publishRelease", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("publishRelease")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"publishRelease", releaseId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"publishRelease", releaseId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestRisks(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject requestRisks(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestRisks");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestRisks");
            context.bindCurrentThread();
            try {
                onRequestRisks(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestRisks", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestRisks")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestRisks", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestRisks");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onSearch(GwtConversation conversation, java.lang.String text);

    @Override
    public scrum.client.DataTransferObject search(int conversationNumber, java.lang.String text) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: search");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:search");
            context.bindCurrentThread();
            try {
                onSearch(conversation, text);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "search", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("search")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"search", text, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"search", text);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onCreateIssueFromTask(GwtConversation conversation, java.lang.String taskId);

    @Override
    public scrum.client.DataTransferObject createIssueFromTask(int conversationNumber, java.lang.String taskId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: createIssueFromTask");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall createIssueFromTask waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:createIssueFromTask");
            context.bindCurrentThread();
            try {
                onCreateIssueFromTask(conversation, taskId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "createIssueFromTask", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("createIssueFromTask")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"createIssueFromTask", taskId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"createIssueFromTask", taskId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onKickStoryFromSprint(GwtConversation conversation, java.lang.String storyId);

    @Override
    public scrum.client.DataTransferObject kickStoryFromSprint(int conversationNumber, java.lang.String storyId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: kickStoryFromSprint");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall kickStoryFromSprint waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:kickStoryFromSprint");
            context.bindCurrentThread();
            try {
                onKickStoryFromSprint(conversation, storyId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "kickStoryFromSprint", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("kickStoryFromSprint")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"kickStoryFromSprint", storyId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"kickStoryFromSprint", storyId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onPullStoryToSprint(GwtConversation conversation, java.lang.String storyId);

    @Override
    public scrum.client.DataTransferObject pullStoryToSprint(int conversationNumber, java.lang.String storyId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: pullStoryToSprint");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall pullStoryToSprint waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:pullStoryToSprint");
            context.bindCurrentThread();
            try {
                onPullStoryToSprint(conversation, storyId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "pullStoryToSprint", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("pullStoryToSprint")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"pullStoryToSprint", storyId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"pullStoryToSprint", storyId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

    protected abstract void onRequestHistory(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject requestHistory(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestHistory");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestHistory");
            context.bindCurrentThread();
            try {
                onRequestHistory(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestHistory", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestHistory")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestHistory", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestHistory");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onRequestHistorySprint(GwtConversation conversation, java.lang.String sprintId);

    @Override
    public scrum.client.DataTransferObject requestHistorySprint(int conversationNumber, java.lang.String sprintId) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: requestHistorySprint");
        WebSession session = (WebSession) getSession();
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:requestHistorySprint");
            context.bindCurrentThread();
            try {
                onRequestHistorySprint(conversation, sprintId);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "requestHistorySprint", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("requestHistorySprint")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"requestHistorySprint", sprintId, "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"requestHistorySprint", sprintId);
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
    }

    protected abstract void onSwitchToNextSprint(GwtConversation conversation);

    @Override
    public scrum.client.DataTransferObject switchToNextSprint(int conversationNumber) {
        ilarkesto.core.base.RuntimeTracker rt = new ilarkesto.core.base.RuntimeTracker();
        log.debug("Handling service call: switchToNextSprint");
        WebSession session = (WebSession) getSession();
        String threads = ilarkesto.base.Threads.getAllThreadsInfo();
        synchronized (getSyncObject()) {
            if (rt.getRuntime() > 1000) log.warn("ServiceCall switchToNextSprint waited for sync", rt.getRuntimeFormated(), ">>> Threads before:\n", threads, "Threads after:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            GwtConversation conversation = null;
            try {
                conversation = session.getGwtConversation(conversationNumber);
            } catch (Throwable ex) {
                log.info("Getting conversation failed:", conversationNumber);
                scrum.client.DataTransferObject dto = new scrum.client.DataTransferObject();
                dto.addError(new ilarkesto.gwt.client.ErrorWrapper(ex));
                return dto;
            }
            ilarkesto.di.Context context = ilarkesto.di.Context.get();
            context.setName("gwt-srv:switchToNextSprint");
            context.bindCurrentThread();
            try {
                onSwitchToNextSprint(conversation);
                onServiceMethodExecuted(context);
            } catch (Throwable ex) {
                handleServiceMethodException(conversationNumber, "switchToNextSprint", ex, context);
            }
            if (rt.getRuntime() > getMaxServiceCallExecutionTime("switchToNextSprint")) {
                log.warn("ServiceCall served in", rt.getRuntimeFormated(),"switchToNextSprint", "Threads:\n", ilarkesto.base.Threads.getAllThreadsInfo());
            } else {
                log.info("ServiceCall served in", rt.getRuntimeFormated(),"switchToNextSprint");
            }
            return (scrum.client.DataTransferObject) conversation.popNextData();
        }
    }

}