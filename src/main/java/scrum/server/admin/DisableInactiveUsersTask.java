package scrum.server.admin;

import ilarkesto.concurrent.ACollectionTask;
import ilarkesto.core.logging.Log;
import ilarkesto.persistence.TransactionService;

import java.util.Collection;

public class DisableInactiveUsersTask extends ACollectionTask<User> {

	private static Log log = Log.get(DisableInactiveUsersTask.class);

	// --- dependencies ---

	private UserDao userDao;
	private TransactionService transactionService;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	// --- ---

	@Override
	protected Collection<User> prepare() throws InterruptedException {
		return userDao.getEntities();
	}

	@Override
	protected void perform(User user) throws InterruptedException {
		if (user.isDisabled()) return;
		if (user.isAdmin()) return;
		if (user.isInactive()) {
			log.warn("Disabling inactive user:", user);
			user.setDisabled(true);
		}
	}

	@Override
	protected void cleanup() throws InterruptedException {
		transactionService.commit();
		super.cleanup();
	}

}
